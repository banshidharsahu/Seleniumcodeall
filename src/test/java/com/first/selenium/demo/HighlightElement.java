package com.first.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HighlightElement

{
	static WebDriver driver;

	@BeforeMethod
	public static void setUp() throws InterruptedException

	{

		// System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");

		/// Priviusly I have did above but now useing below as mismatch chrome vertion and driver vertion
		/// as per google they proviing one chromme vertion for testing purpose.
		/// below is the step
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		/// below chromeOption step we used incase of test chrome used for automation testing scritpt
		ChromeOptions option = new ChromeOptions();
		option.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		// driver.get("https://courses.letskodeit.com/practice");
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		Thread.sleep(2000);
	}

	@Test
	public static void hightElement() {
		WebElement web = driver.findElement(By.xpath("//a/img[@alt='GlobalSQA']"));
		highlight(web);

	}

	public static void highlight(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);

	}

}
