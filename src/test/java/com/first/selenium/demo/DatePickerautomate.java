package com.first.selenium.demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerautomate

{
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/datepicker/");
		System.out.println("Driver configure successfully");

	}

	@Test
	public void datepickerTest() throws InterruptedException

	{
		String expMonth = "December";
		String expyear = "2023";
		String expdate = "22";
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();

		while (true) {
			String actmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String actyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			Thread.sleep(2000);
			if (actmonth.equals(expMonth) && actyear.equals(expyear))

			{
				List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr/td"));

				for (WebElement web : list)

				{
					String date = web.getText();
					if (date.equals(expdate))

					{
						web.click();
						break;
					}
				}
				break;
			}

			else {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}

		}

	}
}
