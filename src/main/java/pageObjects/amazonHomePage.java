package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonHomePage {

	public WebDriver driver;
	
	public amazonHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id = "twotabsearchtextbox")
	WebElement searchBoxText;
	
	@FindBy (css = "img[src = 'https://m.media-amazon.com/images/I/61jyMYiHI+L._AC_SX180_SY120_QL70_.jpg']")
	WebElement searchProduct;
	
	@FindBy (id = "add-to-cart-button")
	WebElement addToCartBtn;
	
	@FindBy (id = "hlb-ptc-btn-native")
	WebElement checkoutBtn;
	
	@FindBy (id = "a-autoid-23-announce")
	WebElement continueBtn;
	
	public WebElement getsearchBoxText() {
		return searchBoxText;
	}
	
	public WebElement getSearchProduct() {
		return searchProduct;
	}
	
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	
	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
	
	public WebElement getContinueBtn() {
		return continueBtn;
	}
}
