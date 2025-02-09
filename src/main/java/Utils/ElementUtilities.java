package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {
	WebDriver driver;
	WebDriverWait wait;
	public ElementUtilities(WebDriver driver) {
		this.driver=driver;
	}
	
public void enterText(WebElement element,long durationOfWait, String textToEnter ) {
	WebElement textField=waitForVisibilityOfElement(element,durationOfWait );
	textField.click();
	textField.clear();
	textField.sendKeys(textToEnter);
}
public void clickOnElement(WebElement element,long durationOfWait) {
	WebElement clickableElement=waitForElementToBeClickable(element,durationOfWait);
	clickableElement.click();
}
public WebElement waitForVisibilityOfElement(WebElement element,long durationOfWait ) {
	wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfWait));
	WebElement webelement=wait.until(ExpectedConditions.visibilityOf(element));
	return webelement;
}
public WebElement waitForElementToBeClickable(WebElement element,long durationOfWait ) {
	wait=new WebDriverWait(driver,Duration.ofSeconds(durationOfWait));
	WebElement webelement=wait.until(ExpectedConditions.elementToBeClickable(element));
	return webelement;
}

}
