package com.first.selenium.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InvisibleDynamicDropdown {
	WebDriver driver;

	@BeforeMethod
	public void steup() throws Exception {
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
		driver.get("https://www.makemytrip.com/");

		Thread.sleep(5000);
	}

	@Test
	public void dropdown() {

		driver.findElement(By.xpath("//a[@class='close']")).click();
		String finddata = "Bengaluru, India";
		driver.findElement(By.id("fromCity")).sendKeys("Bengaluru");

		List<WebElement> str = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']//li"));
		// System.out.println(str);
		for (WebElement web : str)

		{
			String loopdata = web.getText();
			System.out.println(loopdata);
			if (loopdata.contains(finddata)) {
				try {
					web.click();

					break;
				}

				catch (Exception e) {
					System.out.println("unable to click on web element");
				}

			} else {
				System.out.println("datanot");
			}
		}

	}

}
