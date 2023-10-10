package com.first.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OBDXAPPLICATIONTEST {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		// driver.get("https://courses.letskodeit.com/practice");
		driver.get("http://100.76.156.18:7777/");
		Thread.sleep(3000);
	}

	@Test(priority = 1, groups = "A")
	public void login() {
		WebElement login_button = driver.findElement(By.xpath("//span[text()='Login']"));
		login_button.click();
	}

	/// USERNAME & PASSWORD ENTERED
	@Test(priority = 2, groups = "A")
	public void uname_pass() {
		// ENTER USERNAME
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("superadmin");
		// ENTER PASSWORD
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Welcome@1");
		// CLICK ON LOGIN BUTTON
		driver.findElement(By.xpath("//span[text()='Login']")).click();

	}

}
