package pom.modules_pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineShopping {
//Global Variable
Actions act;
WebDriver driverG;
					
//variable
@FindBy (xpath="(//div[@id='nav-xshop']//a)")
private List<WebElement> tabList;	
			
@FindBy (xpath="//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine']//ul//li//a")
private List<WebElement> countryListFooter;	

//constructor
public OnlineShopping(WebDriver driver)
{PageFactory.initElements(driver, this);
this.driverG=driver;
act =new Actions(driverG);}

				
//method	
public int allTabsSize()
{   int a=tabList.size();
return a;}
		
public String allTabsTextget(int indexNo)
{ String g=tabList.get(indexNo).getText();
return g;}

public String allCountryTextget(int indexNo)
{ String g=countryListFooter.get(indexNo).getText();
return g;}
		
	}