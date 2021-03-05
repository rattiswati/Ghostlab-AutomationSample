package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleHomePage {

	public WebDriver driver;
	
	public googleHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name = "q")
	WebElement searchText;
	
	@FindBy (css = "span[class = 'ellip']")
	WebElement amazonLink;
	
	
	public WebElement getSearchTxt() {
		return searchText;
	}
	
	public WebElement getAmazonLink() {
		return amazonLink;
	}
}
