package com.first.selenium.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DDTSQLtest {

	WebDriver driver;
	Connection con;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/login.php/");
		Thread.sleep(1000);

	}

	@Test(priority = 1, groups = "sqlddt")
	public void dragdrop() throws InterruptedException, SQLException {
		String classname = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/seleniumtestdemo";
		String userid = "root";
		String passcode = "Root";
		try {
			Class.forName(classname);
			con = DriverManager.getConnection(url, userid, passcode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Statement st = con.createStatement();
		String log = "select userid,passcode from selenium_test_login";
		ResultSet rs = st.executeQuery(log);

		while (rs.next()) {

			String uname = rs.getString("userid");
			String pass = rs.getString("passcode");
			System.out.println(uname);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(uname);
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(pass);
			driver.findElement(By.xpath("//button[@type='submit']")).click();

		}
		con.close();

	}

}
