package com.first.selenium.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;

public class ReadingExcel {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {

		// Read URL from excel sheet
		File src = new File("D:\\JAVA juju study\\Anathaexcel.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook s = new XSSFWorkbook(fis);
		XSSFSheet st = s.getSheetAt(1);
		String url = st.getRow(0).getCell(0).getStringCellValue();
		// System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");

		/// Priviusly I have did above but now useing below as mismatch chrome vertion and driver vertion
		/// as per google they proviing one chromme vertion for testing purpose.
		/// below is the step
		System.setProperty("webdriver.chrome.driver", "D:/Seleniumtest/demo/Driver/chromedriver.exe");
		/// below chromeOption step we used incase of test chrome used for automation testing scritpt
		ChromeOptions option = new ChromeOptions();
		// option.setBinary("D:/Seleniumtest/demo/testChromeBrowser/chrome.exe");
		option.setBinary("C:/User/bansahu/Downloads/chrome-win/chrome.exe");

		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get(url);
		Thread.sleep(1000);
	}

	@Test(priority = 1, groups = "readexcel")
	public void readExcel() throws InterruptedException, IOException, BiffException

	{
		File src = new File("D:\\JAVA juju study\\Anathaexcel.xlsx");
		// C:\\Users\\DELL\\Documents\\Benu_Excel\\Readexcelselenium.xlsx
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet st = workbook.getSheetAt(0);

		WebElement un = driver.findElement(By.id("email"));
		WebElement pa = driver.findElement(By.id("pass"));

		// String entr = st.getRow(1).getCell(0).getStringCellValue();

		int rowcount = st.getLastRowNum();

		for (int i = 1; i < rowcount; i++) {
			String dataun = st.getRow(i).getCell(0).getStringCellValue();
			un.sendKeys(dataun);
			String datapass = st.getRow(i).getCell(1).getStringCellValue();
			pa.sendKeys(datapass);
			// File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Files.copy(f, new File("C:\\Users\\DELL\\Documents\\SeleniumScreenshot\\dragdropscreenshot.jpg" ));
			Thread.sleep(2000);
			pa.clear();
			un.clear();
			Thread.sleep(1000);
		}

	}

}
