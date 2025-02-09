package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.ElementUtilities;

public class Dashboard {
	WebDriver driver;
	ElementUtilities Util;
@FindBy(css="input[placeholder='Search']")
private WebElement searchOption;

public Dashboard(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	Util=new ElementUtilities(driver);
}
public boolean visibleSearchOption(long time) {
	searchOption=Util.waitForVisibilityOfElement(searchOption, time);
	return searchOption.isDisplayed();
}

}
