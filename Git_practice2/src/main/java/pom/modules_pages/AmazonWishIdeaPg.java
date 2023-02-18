package pom.modules_pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonWishIdeaPg{
//Global Variable
	Actions act;
	WebDriver driverG;
	
	
//variable
@FindBy (xpath="//ul[@id='g-items']//li//span//div//h2//a")
private WebElement ProductNameWishRAw;
		
@FindBy (xpath="//input[@name='submit.deleteItem']")
private WebElement deleteBtn;

@FindBy (xpath="//span[text()='Account & Lists']")
private WebElement accountandlist1;

@FindBy (xpath="//span[text()='Sign Out']")
private WebElement signoutBtn;

@FindBy (xpath="(//div[@class='a-section']//span[contains(text(),'out of 5 stars')])[1]")
private WebElement product1RatinginWishList;



//constructor
public AmazonWishIdeaPg(WebDriver driver)
{PageFactory.initElements(driver, this);	
this.driverG=driver;
act =new Actions(driverG);}


		
//method
public String  getNameofProductInWishList()	
{	String productNameOriginal=ProductNameWishRAw.getText();
    return productNameOriginal;}
		
public void clickonDeleteBtn()
{deleteBtn.click();}

public void clickOnACListandClickSignOut()
{ act.moveToElement(accountandlist1).moveToElement(signoutBtn).click().build().perform();}

public boolean checkDisplayedProduct1RatinginWishList()
{boolean product1Rating=product1RatinginWishList.isDisplayed();
return product1Rating;}

}