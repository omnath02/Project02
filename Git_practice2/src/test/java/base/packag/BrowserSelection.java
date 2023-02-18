package base.packag;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class BrowserSelection {
	//static WebDriver driver;

/*public static WebDriver openChromeBrowser()
{	System.setProperty("webdriver.chrome.driver", "src/test/resourses\\browser\\chromedriver.exe"); 
   WebDriver driver = new ChromeDriver(); 
   return driver;	} */

public static WebDriver openChromeBrowser()
{	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browser\\chromedriver.exe"); 
   WebDriver driver = new ChromeDriver(); 
   return driver;	} 




public static WebDriver openFirefoxBrowser()
{	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\browser\\geckodriver.exe");
   WebDriver driver = new FirefoxDriver(); 
   return driver;	} 
	
	
public static WebDriver openEdgeBrowser()
{System.setProperty("webdriver.edge.driver", "src/test/resources\\browser\\msedgedriver.exe");
   WebDriver driver = new EdgeDriver(); 
   return driver;	} 
	
public static WebDriver openOperaBrowser()
{	System.setProperty("webdriver.operadriver.driver",  "src/test/resources\\browser\\operadriver.exe");
   WebDriver driver = new OperaDriver(); 
   return driver;	} 

}