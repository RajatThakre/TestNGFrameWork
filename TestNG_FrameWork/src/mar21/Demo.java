package mar21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;
	@Test
	public void startTest()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		String Expected="Google";
		String Actual=driver.getTitle();
		try {
		Assert.assertEquals(Actual, Expected, "Title is not matching");
		}catch (AssertionError e) {
		 System.out.println(e.getMessage());
		}
		try {
		Assert.assertTrue(Actual.equalsIgnoreCase(Expected), "Title is not matching");
		}catch (Throwable a) {
			System.out.println(a.getMessage());
		}
		try {
			Assert.assertFalse(Actual.equalsIgnoreCase(Expected), "Title is matching");
		} catch (Throwable s) {
			System.out.println(s.getMessage());
		}
		driver.quit();
	}

}
