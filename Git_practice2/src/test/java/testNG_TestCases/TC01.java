package testNG_TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utils.UtilityMy;
import base.packag.BrowserSelection;
import pom.modules_pages.HeaderPage;
import pom.modules_pages.Productpage;
import pom.modules_pages.ShoppingCartPage;
import pom.modules_pages.Signinpage;
import pom.modules_pages.SpecificProductpage;

public class TC01 extends BrowserSelection{
		
	//Globally variables
	private WebDriver driverTest;
	
	private String originalProductName;           ////////////////////////////////////
	
	private HeaderPage headerPage;
	private Productpage productpage ;
	private Signinpage signinpage; 
	private SpecificProductpage specificProductpage ;
	private ShoppingCartPage shoppingCartpage;
	private SoftAssert asrt ;
	//private ArrayList<String> addr;
	private JavascriptExecutor js;

	private String testID;
	private static ExtentTest test;
	private static ExtentHtmlReporter reporter;
	


	@Parameters("browser123")
	@BeforeTest
	public void launchBrowser(String browser)
	{
	//reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
	//ExtentReports extend = new ExtentReports();
	//extend.attachReporter(reporter);
	System.out.println("BeforeTest to launch browser");
	
	if(browser.equals("chrome"))
	   { 	driverTest =BrowserSelection.openChromeBrowser();   }

	if(browser.equals("firefox"))
	{ 	driverTest =openFirefoxBrowser();   }

	if(browser.equals("edge"))
	{ 	driverTest =openEdgeBrowser();   }

	if(browser.equals("opera"))
	{ 	driverTest =openOperaBrowser();   }

	driverTest.manage().window().maximize();}
	
/*@BeforeTest         // browser launch
	public void beforeTest()
{System.out.println("before class");
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\Velocity\\Selenium\\drivers\\chromedriver.exe");
	
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browser\\chromedriver.exe");
	driverTest= new ChromeDriver();
	
	
		
	//System.setProperty("webdriver.gecko.driver", "src/test/resources\\browser\\geckodriver.exe");
	//driverTest= new FirefoxDriver();
	 
	
	//driverTest= new ChromeDriver();
	driverTest.manage().window().maximize();
	//driverTest.manage().window().
	
	}*/
	
	
	
@BeforeClass       // variable ref object create
public void beforeclass()
{System.out.println("BeforeClass to AllObject create and globally ref variables create");
       
productpage=new Productpage(driverTest);
headerPage =new HeaderPage(driverTest);
signinpage=new Signinpage(driverTest);
specificProductpage =new SpecificProductpage(driverTest);
shoppingCartpage=new ShoppingCartPage(driverTest);
//addr =new ArrayList<String> (driverTest.getWindowHandles());
js=(JavascriptExecutor)driverTest; 

}
	
		
		
@BeforeMethod        // implicitWait        URl     login code
public void beforemethod() throws InterruptedException, EncryptedDocumentException, IOException
{System.out.println("BeforeMethod Annotation");
driverTest.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
driverTest.get(UtilityMy.readExcelData("amazonProperty", 1, 0));



//step 3 click on account list and click on sign in
headerPage.clickonaccountntandlistandClickSignIn();


// step 4 enter email,click on  continue btn ,enter password and click on sign in  btn	
signinpage.enterEmailormobno(UtilityMy.readExcelData("amazonMaven", 1, 0));
signinpage.clickoncontinuebtn();
signinpage.enterPasswordbtn(UtilityMy.readExcelData("amazonMaven", 1, 1));
signinpage.clickonsigninbtn();
	
asrt =new SoftAssert();	}
		
		
@Test(priority=0)
public void tc01() throws InterruptedException, EncryptedDocumentException, IOException
{ System.out.println("Test Annotation");
testID="tc01";

//5 Search product	 
headerPage.clickonsearchbox(UtilityMy.readExcelData("amazonMaven", 1, 2));
headerPage.clickonsearchbtn();

//Step 6 select first product from display list	
productpage.clickonfirstResult();
Thread.sleep(5000);

//step 7 shift driver focus to new window
//driverTest.switchTo().window(addr.get(1));

ArrayList<String> addr = new ArrayList<String>(driverTest.getWindowHandles());
driverTest.switchTo().window(addr.get(1));

//Step 8 take price of specific product and print	
String originalPrice= specificProductpage.getpriceOfProduct();
System.out.println(originalPrice);
			
// Step 8.1 Take name of specific product and Print
originalProductName= specificProductpage.getproductSpecificName();
System.out.println(originalProductName);
	
	
//step 8.2  write product name in excel
UtilityMy.writeExcelData("amazonMaven", 1, 6, originalProductName);
Thread.sleep(2000);
	
	
//step 9  scroll down 
js.executeScript("window.scrollBy(0,400)");

//step 10 click on add to cart Btn
Thread.sleep(2000);
specificProductpage.clickonAdd2cart();
Thread.sleep(2000);
	
// cart pop up 
boolean result=specificProductpage.checkCloseBtnofCartPopup();
if(result==true)
{specificProductpage.clickcloseBtnofCartPopup();}
	

Thread.sleep(2000);
//step 11  click on cart tab
headerPage.clickonCartTab();

//Step 12 take price of specific product and print From Cart 
String cartProductPrice=shoppingCartpage.getPriceofProductInCart();
System.out.println(cartProductPrice);

//Step 13 Compare original product price and Cart Product Price

//globally create
asrt.assertEquals(originalPrice, cartProductPrice, "message1------> OK");
	
	if(originalPrice.equals(cartProductPrice))
	{System.out.println("Test Pass");}
	else
	{System.out.println("Test Fail");}

	//Step 14 go to drop down and select 0 for deleting the product
	//shoppingCartpage.clickonDeleteBtnIncartandDeleteProduct();
	
//Step 12 take Name of specific product and print From Cart 
 String  cartProductName=shoppingCartpage.getproductSpecificNameFromCart();
System.out.println(cartProductName);

//Step 13 Compare original product price and Cart Product Price	
	
if(originalProductName.equals(cartProductName))
{System.out.println("Test Pass");}
else
{System.out.println("Test Fail");}
	
	
asrt.assertEquals(originalProductName, cartProductName, "message2 ------> OK");
asrt.assertAll();
	}

@AfterMethod         // Listener            //screen shot          // signOut
public void afterMethod(ITestResult result) throws InterruptedException, IOException
{System.out.println("After Method Annotation");

if (ITestResult.FAILURE == result.getStatus() )
{UtilityMy.takesScreenShott(testID, driverTest);}


System.out.println("***************");

Thread.sleep(2000);
driverTest.close();


//shift focus to parent window
ArrayList<String> addr = new ArrayList<String>(driverTest.getWindowHandles());
driverTest.switchTo().window(addr.get(0));

//logout 
headerPage.clickOnACListandClickSignOut(); 
//driverTest.navigate().refresh();
}////////////////
	
		
		@AfterClass
		public void afterClass()
		{System.out.println("AfterClass Annotation");	
		
	
		originalProductName=null;
		headerPage=null;
		productpage =null;
	    signinpage=null;
		specificProductpage=null;
		shoppingCartpage=null;
		testID=null;	
		
		}    		
		
		@AfterTest
		public void afterTest()
		{System.out.println("After Test");
	 driverTest.quit();
		 driverTest =null;
		 System.gc();}
		
	}