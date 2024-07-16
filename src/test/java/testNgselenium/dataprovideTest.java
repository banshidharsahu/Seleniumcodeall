package testNgselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dataprovideTest {
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		// WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

	}

	@Test(dataProvider = "dataprovideDemo", dataProviderClass = Dataprovide.class)
	public void datatest(String contry, String city)

	{

		WebElement web = driver.findElement(By.xpath("//textarea[@type='search']"));
		web.sendKeys(contry + " " + city);
	}
}
