package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties property = new Properties();
	public WebDriver InitializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		property.load(fis);
		String browserName = property.getProperty("browser");
		/* Invoke chrome if browser required is Chrome */
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		/* Invoke firefox if browser required is firefox */
//		else if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",
//					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} 
	else {
			System.out.println("browser not available");
		}

		return driver;
	}
}
