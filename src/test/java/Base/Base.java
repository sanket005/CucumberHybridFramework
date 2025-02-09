package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Unit test for simple App.
 */
public class Base {
	private static WebDriver driver;
	static Properties prop;
	public Base(WebDriver driver) {
		Base.driver=driver;
	}
	public static WebDriver DriverFactory() {
		prop=Base.propFileReading();
		if(prop.getProperty("BrowserName").equals("Chrome")) {
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("BrowserName").equals("Firefox")) {
			driver=new FirefoxDriver();
		}
		return driver;
	}
  public static Properties propFileReading() {
	  prop=new Properties();
	  	  try {
		  FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config\\config.properties");
		 prop.load(fis);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  	  
	  return prop;
  }
  public static WebDriver getDriver() {
	  return driver;
  }
 
}
