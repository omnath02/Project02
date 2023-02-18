package pom.modules_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoppingCartPage {
	//Global Variable
	Actions act;
	
	//variable
		@FindBy (xpath="//div[@id='sc-active-cart']//form//div[@class='sc-item-price-block']")
		private WebElement ProductpriceCartRAw;
		
		@FindBy (xpath="(//input[@value='Delete'][@type='submit'])[1]")
		private WebElement deleteCartProductBtn;
		
		@FindBy (xpath="//span[text()='Account & Lists']")
		private WebElement accountandlist1;
		
		@FindBy (xpath="//span[text()='Sign Out']")
		private WebElement signoutBtn;
		
		@FindBy (xpath="(//form[@id='activeCartViewForm']//li//a//span[2])[1]")
		private WebElement productNameFromCart;

				
			
		//constructor
		public ShoppingCartPage(WebDriver driver)
		{PageFactory.initElements(driver, this);
		
		act=new Actions(driver);}
		
			//method
public String  getPriceofProductInCart()	
{	String productPriceOriginal=ProductpriceCartRAw.getText().replace(".00", "").trim();
    return productPriceOriginal;}
		
			
		
public void clickonDeleteBtnIncartandDeleteProduct()	
		{	deleteCartProductBtn.click();	}

		
public void clickOnACListandClickSignOut()
{ act.moveToElement(accountandlist1).moveToElement(signoutBtn).click().build().perform();}
		

public String getproductSpecificNameFromCart()	
{	String productSpName =	productNameFromCart.getText() ;
return productSpName;}

}

