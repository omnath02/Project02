package pom.modules_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
//variable
@FindBy (xpath="(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
private WebElement firstResult;
//By.xpath("(//div[@id='search']//span//div//h2//a//span)[1]"));

@FindBy (xpath="(//div[@id='search']//a//span[@class='a-price-whole'])[1]")
private WebElement firstResultPrice;

@FindBy (xpath="//span[text()='Samsung']")
private WebElement filterBrandSamsung;

@FindBy (xpath="//span[contains(text(),'Over ')]")
private WebElement filterPriceOver_20;


//constructor
public Productpage(WebDriver driver)
{PageFactory.initElements(driver, this);}


//method
public void clickonfirstResult()	
{		firstResult.click();    }

public String getTextofFirstResult()	
{	String productNamefromSearch=firstResult.getText(); 
     return productNamefromSearch;}

public int getPriceofFirstResult()	
{  String productPricefromSearch=firstResultPrice.getText().replace(",", "");
   int productPrice=Integer.parseInt(productPricefromSearch);
   return productPrice;}


public void clickonfilterBrandSamsung()	
{		filterBrandSamsung.click();    }

public void filterPriceOver_20()	
{		filterPriceOver_20.click();    }
	
}