package Hooks;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	Properties prop;
	WebDriver driver;
	
@Before
public void setup() {
	prop=Base.propFileReading();
	 driver=Base.DriverFactory();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30000));
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
//	driver.get(prop.getProperty("URL"));
}

@After 
public void tearDown(Scenario scn) throws IOException {
	String scname=scn.getName().replace(" ", "_");
	if(scn.failed()){
		TakesScreenshot Ts=(TakesScreenshot) driver;
		scn.attach(Ts.getScreenshotAs(OutputType.BYTES),"image/png",scname);
	}
	driver.close();
	File file=new File("D:\\CucumberFramework\\target\\Report.html");
	Desktop.getDesktop().browse(file.toURI());
}
}
