package com.first.selenium.demo;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Brokenlinkcheck {

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
		driver.get("http://www.deadlinkcity.com/");
		Thread.sleep(1000);
	}

	@Test
	public void dropdown()

	{
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		int status = 200;
		for (WebElement web : list) {
			String a = web.getAttribute("href");
			try {
				URL url = new URL(a);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("HEAD");
				con.connect();
				status = con.getResponseCode();
				if (status >= 400) {
					System.out.println(a + " " + "BrokenLinks");
				}

			} catch (MalformedURLException e) {

			} catch (Exception e) {

			}

		}
	}
}

// ul[@id='ui-id-1']//li