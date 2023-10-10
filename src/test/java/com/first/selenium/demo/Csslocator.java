package com.first.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Csslocator {
	WebDriver driver;

	@BeforeMethod
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		/// below chromeOption step we used incase of test chrome used for automation testing scritpt
		ChromeOptions option = new ChromeOptions();
		option.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(1000);
	}

	@Test
	public void test() throws InterruptedException {
		/// Tag with id
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		/// Tag with attribute=value
		driver.findElement(By.cssSelector("input[name=password]")).sendKeys("secret_sauce");
		/// tag and class value
		driver.findElement(By.cssSelector("input.submit-button")).click();
		Thread.sleep(2000);
		/// tag, class and atribute combination
		driver.findElement(By.cssSelector("button.btn[name=add-to-cart-sauce-labs-backpack]")).click();
		Thread.sleep(2000);
		String str = driver.findElement(By.cssSelector("button.btn[name=remove-sauce-labs-backpack]")).getText();
		Assert.assertEquals(str, "Remove", "successfully added");

		/// By using sub string like endWith or startWith
		/// if want to use start with then sign is ^ and if end with then $ and if want use content then sign *
		driver.findElement(By.cssSelector("button[name$=light]")).click();

	}
}
