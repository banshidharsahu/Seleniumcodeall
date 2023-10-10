package com.first.selenium.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutodinamicDropdown {
	WebDriver driver;

	@BeforeMethod
	public void steup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		/// below chromeOption step we used incase of test chrome used for automation testing scritpt
		ChromeOptions option = new ChromeOptions();
		option.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
	}

	@Test
	public void dropdown() {

		List<WebElement> str = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		// System.out.println(str);
		for (WebElement web : str)

		{
			String loopdata = web.getText();
			System.out.println(loopdata);

		}
		/// By using Select class also we can do above function.
		Select select = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1")));
		System.out.println("Banhsi");
		/// if want to get all options then getoptio
		List<WebElement> list = select.getOptions();

		/// that is I want select text in dropdown
		select.selectByVisibleText("Bagdogra (IXB)");

	}
}

// ul[@id='ui-id-1']//li