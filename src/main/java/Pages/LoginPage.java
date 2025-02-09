package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;
import io.opentelemetry.api.internal.Utils;

/**
 * Hello world!
 *
 */
public class LoginPage 
{
	WebDriver driver;
	private ElementUtilities util;
     @FindBy (xpath="//input[@name='username']")
     private WebElement username;
     @FindBy (xpath="//input[@name='password']")
     private WebElement password;
     @FindBy (xpath="//button[@type='submit']")
     private WebElement Submit;
     @FindBy (css=".oxd-alert-content.oxd-alert-content--error")
     private WebElement errorMsg;
     public LoginPage(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
    	 util=new ElementUtilities(driver);
     }
     
     public void EnterUserName(String usernameText, long time) {
    	util.enterText(username,time,usernameText);
     }
     public void EnterPassword(String passText, long time) {
     	util.enterText(password,time,passText);
      }
     public void clickOnSubmit( long time) {
    	 
      	util.clickOnElement(Submit, time);
       }
     public String getErrorMsg(long time) {
    	 errorMsg=util.waitForVisibilityOfElement(errorMsg, time);
    	 return errorMsg.getText();
        }
}
