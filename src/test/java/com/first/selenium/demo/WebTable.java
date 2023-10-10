package com.first.selenium.demo;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTable

{
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.get("https://money.rediff.com/gainers");
		Thread.sleep(2000);

	}

	@Test
	public void webtable_handle() throws ParseException, InterruptedException

	{

		// List<WebElement> common = driver.findElements(By.xpath("//table//thead//tr//th"));
		// List<WebElement> rowsize = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		// int size = rowsize.size();
		// for (WebElement web : common) {
		// String webstring = web.getText();
		// if (webstring.equals("Current Price (Rs)")) {
		//
		// }
		// }

		String max;
		double n = 0, r = 0;
		List<WebElement> colomn = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
		System.out.println("Total colomn" + " " + colomn.size());
		Thread.sleep(1000);
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
		System.out.println("Total Rows" + " " + rows.size());
		List<Number> list = new ArrayList<Number>();
		// System.out.println("Mininum character is: " + Collections.min(list, null));
		// Get Max number of data in a dynanic column
		// ===============================================
		for (int i = 0; i < rows.size(); i++) {
			max = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[" + (i + 1) + "]/td[4]"))
					.getText();
			NumberFormat num = NumberFormat.getNumberInstance();
			Number f = num.parse(max);
			// list.add(f);

		}

		System.out.println(r);

	}
}
