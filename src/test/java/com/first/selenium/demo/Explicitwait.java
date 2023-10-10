package com.first.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Explicitwait {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/2013/05/page-one.html");
	}

	@Test
	public void explicitwait() {
		driver.findElement(By.xpath("//button[text()='Dropdown']")).click();

		WebDriverWait wait = new WebDriverWait(driver, null);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Flipkart']")));
		try

		{
			driver.findElement(By.xpath("//a[text()='Flipkart']")).click();
		}

		catch (Exception e)

		{
			System.out.println("Element not vissible");
		}

	}
}
