package com.first.selenium.demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ScreenshotTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Thread.sleep(1000);
	}

	@Test(priority = 1, groups = "Dragdrop")
	public void dragdrop() throws InterruptedException, IOException {

		// open Amazon page and take Full screenshot
		/*
		 * File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * Files.copy(f, new File("D://screenshotselenium//amazontest.jpg"));
		 */

		/// I want to take a screenshot of perticular a section of amazon home page below is the code
		File section = driver.findElement(By.xpath("//div[@id='gw-desktop-herotator']"))
				.getScreenshotAs(OutputType.FILE);

		Files.copy(section, new File("D://screenshotselenium//amazonsinglesection.jpg"));

		/// IF want to take screenshot for a perticular webelement then the same its like section code only xpath will
		/// change as per webelement

	}

}
