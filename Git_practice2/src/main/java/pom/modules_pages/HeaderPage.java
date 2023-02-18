package pom.modules_pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {
	//Global Variable
		Actions act;
		WebDriver driverG;
		JavascriptExecutor js;
		
				
	//variable
		@FindBy (xpath="//span[text()='Account & Lists']")
		private WebElement accountandlist;	
		
		@FindBy (xpath="(//span[text()='Sign in'])[1]")
		private WebElement signBtn;
		
		@FindBy (xpath="//input[@id='twotabsearchtextbox']")
		private WebElement searchbox;

		@FindBy (xpath="//input[@type='submit']")
		private WebElement searchbtn;
				
        @FindBy (xpath="//span[text()='Sign Out']")
	    private WebElement signoutBtn;
        
        @FindBy (xpath="//span[@id='nav-cart-count']")
    	private WebElement cartOptn;
        
        @FindBy (xpath="//span[@id='nav-cart-count']")
    	private WebElement cartCOUNT;
      
        @FindBy (xpath="//span[text()='Your Wish List']")
    	private WebElement yourWishListTab;
        
      

//constructor
public HeaderPage(WebDriver driver)
{PageFactory.initElements(driver, this);
this.driverG=driver;
act =new Actions(driverG);
js =(JavascriptExecutor) driver;}

			
	//method	
	public void clickOnACListandClickSignOut() throws InterruptedException
	{ act.moveToElement(accountandlist).build().perform();
	  Thread.sleep(1000);
	 act.moveToElement(signoutBtn).click().build().perform();}
	
	
	public void clickonaccountntandlistandClickSignIn() throws InterruptedException
	{ act.moveToElement(accountandlist).build().perform();
	  Thread.sleep(1000);
	 act.moveToElement(signBtn).click().build().perform();}
	
	
	public void clickonaccountntandlistandyourWishListTab() throws InterruptedException
	{ act.moveToElement(accountandlist).build().perform();
	  Thread.sleep(1000);
	 //act.moveToElement(yourWishListTab).click().build().perform();
	 
	  js.executeScript("arguments[0].click()", yourWishListTab );
	}

	
	
	
	
	public void clickonsearchbox(String product)
	{searchbox.sendKeys(product);		}
	
	public void clickonsearchbtn()
	{searchbtn.click();}
	
	public void clickonCartTab()	
	{	cartOptn.click();	  }
	
	public int cartCOUNT()	
	{	String countCart=cartCOUNT.getText();	
	     int cartCount= Integer.parseInt(countCart);
	    return cartCount;}
	
}