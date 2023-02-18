package pom.modules_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signinpage {
private WebDriver driverG;
	
	//variable
			@FindBy (xpath="//input[@id='ap_email']")
			private WebElement emailormobno;	
			
			@FindBy (xpath="//input[@id='continue']")
			private WebElement continuebtn;
			
			@FindBy (xpath="//input[@id='ap_password']")
			private WebElement passwordbtn;	
			
			@FindBy (xpath="//input[@id='signInSubmit']")
			private WebElement signinbtn;
			
			//@FindBy (xpath="//input[@type='submit']")
			//private WebElement searchbtn;
			

			//constructor
			public Signinpage(WebDriver driver)
			{PageFactory.initElements(driver, this);
			this.driverG=driver;
			}
				
			//method
			public void enterEmailormobno(String number)	
			{emailormobno.sendKeys(number);
 } 
			
			public void clickoncontinuebtn()	
			{continuebtn.click(); } 
			
					
			public void enterPasswordbtn(String password )	
			{passwordbtn.sendKeys(password); } 
			
			public void clickonsigninbtn()	
			{signinbtn.click();  } 

}