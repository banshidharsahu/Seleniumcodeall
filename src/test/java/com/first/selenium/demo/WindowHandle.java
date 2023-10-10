package com.first.selenium.demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

		Thread.sleep(1000);
	}

	@Test(priority = 1, groups = "Copypastpassword")
	public void window() throws InterruptedException {
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
		Set<String> child = driver.getWindowHandles();
		for (String childwindow : child) {
			if (!childwindow.equals(parent)) {
				/// here selenium driver swich to childwindow
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("banshidhar");
				Thread.sleep(2000);
				driver.close();

			}

		}
		/// here selenium driver swich to parent window
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Banshisahu");

		/// ******Tab handle///

		driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();

		Set<String> Tab = driver.getWindowHandles();
		for (String childtab : Tab) {
			if (!childtab.equals(parent)) {
				driver.switchTo().window(childtab);
				Thread.sleep(2000);

				driver.findElement(By.xpath("//button[@id='alertBox']")).click();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				Thread.sleep(1000);

				driver.close();
			}

		}

		Thread.sleep(3000);
		driver.quit();

	}

}
