package Ghostlab.Amazon;

import java.io.IOException;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.amazonHomePage;
import pageObjects.googleHomePage;
import resources.base;

public class AmazonTest extends base {

	@BeforeTest
	public void BeforeTest() throws IOException {
		driver = InitializeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test

	public void AmazonAutomationStart () {

		String browserName = property.getProperty("googleURL");
		String googlePageTitle = property.getProperty("googlePageTitle");
		String searchText = property.getProperty("searchText");
		String amazonHomePage = property.getProperty("websiteName");
		String searchCouch = property.getProperty("couchSearchText");
		String amazonPageTitle = property.getProperty("amazonPageTitle");

		googleHomePage gHomePage = new googleHomePage(driver);
		amazonHomePage aHomePage = new amazonHomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5000);

		driver.get(browserName);
		Assert.assertEquals(driver.getTitle(), googlePageTitle);
		gHomePage.getSearchTxt().sendKeys(searchText);
		gHomePage.getSearchTxt().sendKeys(Keys.ENTER);
		Assert.assertEquals(gHomePage.getSearchTxt().getAttribute("value"), searchText);
		gHomePage.getAmazonLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), amazonHomePage);
		Assert.assertEquals(driver.getTitle(), amazonPageTitle);

		aHomePage.getsearchBoxText().sendKeys(searchCouch);
		aHomePage.getsearchBoxText().sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOf(aHomePage.getSearchProduct()));
		Assert.assertTrue(aHomePage.getSearchProduct().isDisplayed());
		aHomePage.getSearchProduct().click();

		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(aHomePage.getAddToCartBtn())));
		Assert.assertTrue(aHomePage.getAddToCartBtn().isDisplayed(),"couch is displayed");
		aHomePage.getAddToCartBtn().click();

		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(aHomePage.getCheckoutBtn())));
		aHomePage.getCheckoutBtn().click();

		driver.close();
	}

}
