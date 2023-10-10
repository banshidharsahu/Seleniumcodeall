package com.first.selenium.demo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	public int count = 0;
	public int maxcount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (count < maxcount) {
			count++;
			return true;
		} else {
			return false;
		}

	}

	/// Below code you should written in test script class
	// @Test(retryAnalyzer = Retry.class)
	// public void test()
	//
	// {
	// Assert.assertTrue(true);
	// }

}
