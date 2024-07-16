package testNgselenium;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTestNg

{

	@Test
	@Parameters({ "i", "j" })

	public void add(int a, int b)

	{
		System.out.println(a + b);
	}

	@Test
	@Parameters({ "i", "j" })
	public void sub(int a, int b)

	{
		System.out.println(a - b);
	}

	@Test
	@Parameters({ "i", "j" })
	public void multiple(int a, int b)

	{
		System.out.println(a * b);
	}

}
