package com.first.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElementColor {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.tutorialspoint.com/how-to-verify-color-of-a-web-element-in-selenium-webdriver");
		Thread.sleep(1000);
	}

	@Test

	public void elementcolor() {
		WebElement web = driver.findElement(By.xpath("//div[@id='left-user-profile']"));

		String s = web.getCssValue("color");
		// convert rgba to hex
		String c = Color.fromString(s).asHex();
		System.out.println("Color is :" + s);
		System.out.println("Hex code for color:" + c);
	}
}
