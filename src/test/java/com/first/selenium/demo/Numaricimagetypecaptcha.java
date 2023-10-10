package com.first.selenium.demo;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Numaricimagetypecaptcha {
	WebDriver driver;

	@BeforeMethod
	public void steup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://captcha.com/demos/features/captcha-demo.aspx");
		Thread.sleep(1000);
	}

	@Test
	public void mathcaptcha() throws InterruptedException

	{
		//// This type of Captcha selenium direct can't handle so for that need to hold our cose in runtime and auto
		//// open dilog box and enter data then selenium will enter data and validate
		String str = JOptionPane.showInputDialog("Enter your captcha");
		/// the above Joptionpane will open dialog box where need to enter captcha

		driver.findElement(By.xpath("//input[@id='captchaCode']")).sendKeys(str);
		driver.findElement(By.xpath("//input[@id='validateCaptchaButton']")).click();
		Thread.sleep(5000);
		driver.quit();
	}

	@AfterMethod
	public void close()

	{
		// driver.quit();
	}

}
