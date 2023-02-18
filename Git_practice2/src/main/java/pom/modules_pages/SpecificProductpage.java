package pom.modules_pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecificProductpage {
	//variable
	int a;
	@FindBy (xpath="//div[@id='corePriceDisplay_desktop_feature_div']//span[2]//span[2]//span[2]")
	private WebElement productPriceRaw;
	
	@FindBy (xpath="//input[@id='add-to-cart-button']")
	private WebElement addToCart;
	
	@FindBy (xpath="//a[@id='attach-close_sideSheet-link']")
	private WebElement closeBtnCartPopup;
	
	

	@FindBy (xpath="//h1[@id='title']//span[@id='productTitle']")//smartTV name//mobile name
	private WebElement productName;
	//h1[@id='title']//span[@id='productTitle']
	
	@FindBy (xpath="//span[@id='huc-view-your-list-button']")
	private WebElement viewWishBtn;
	
	@FindBy (xpath="//input[@id='add-to-wishlist-button-submit']")
	private WebElement addWishBtn;
	
	
	
	//constructor
	public SpecificProductpage(WebDriver driver)
	{PageFactory.initElements(driver, this);}
	
	
	
	
	//method
	public String getpriceOfProduct()	
	{	String productPrice= productPriceRaw.getText();	
	    return  productPrice;	}
	
	
	public void clickonAdd2cart()	
	{	addToCart.click();	  }
	
	public void clickcloseBtnofCartPopup()	
	{	closeBtnCartPopup.click();	  }
	
	
	public boolean checkCloseBtnofCartPopup()	
	{	boolean result=closeBtnCartPopup.isDisplayed(); 
	       return result; }
	
	
	public String getproductSpecificName()	
	{	String productSpName =	productName.getText() ;
	    return productSpName;}
	
	public void clickonViewWishListBtnPopup()	
	{	viewWishBtn.click();	  }
	
	public void clickonAddWishListBtn()	
	{	addWishBtn.click();	  }
	
}
