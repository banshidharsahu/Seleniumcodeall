package com.first.selenium.demo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practicedemo

{
	WebDriver driver;

	@BeforeMethod
	public void setup()

	{
		// System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		// ChromeOptions chrome = new ChromeOptions();
		// chrome.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");
		/// driver = new ChromeDriver();

		// driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.get("https://captcha.com/demos/features/captcha-demo.aspx");
		// System.out.println("Title of the page: " + driver.getTitle());
		/// Use WebDriverManager to manage ChromeDriver

		// /// below is the automatic process for driver update
		// WebDriverManager.chromedriver().setup();
		//
		// // Create a WebDriver instance for Chrome
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// // Perform your Selenium tests
		driver.get("https://money.rediff.com/indices");
		// System.out.println("Title of the page: " + driver.getTitle());

	}

	@Test()
	public void test() throws InterruptedException

	{

		driver.findElement(By.xpath("//a[@id='showMoreLess']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//table//tbody//tr/td[5]"));
		List<Double> D = new LinkedList<Double>();
		for (WebElement web : list)

		{
			String collon = web.getText();
			double data = Double.parseDouble(collon);

			D.add(data);

		}
		Collections.sort(D);
		double ele = D.get(D.size() - 2);
		System.out.println(ele);
	}

}
