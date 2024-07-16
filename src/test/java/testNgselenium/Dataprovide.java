package testNgselenium;

import org.testng.annotations.DataProvider;

public class Dataprovide

{
	@DataProvider(name = "dataprovideDemo")
	public Object[][] dataprovide() {
		Object[][] object = new Object[3][2];
		object[0][0] = "India";
		object[0][1] = "Odisha";
		object[1][0] = "India";
		object[1][1] = "bangalor";
		object[2][0] = "India";
		object[2][1] = "Hydrabad";

		return object;
	}
}
