package mar18;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGClass {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtuId")).sendKeys("Admin");
		driver.findElement(By.name("txtPword")).sendKeys("Admin");
		driver.findElement(By.name("login")).click();
		Reporter.log("Running in beforetest",true);
	}
	@Test
	public void branches() {
		driver.findElement(By.xpath("(//img)[5]")).click();
		Reporter.log("Excuting branch test",true);
	}
	@Test
	public void roles() {
		driver.findElement(By.xpath("(//img)[6]")).click();
		Reporter.log("Excuting roles test",true);
	}
	@Test
	public void users() {
		driver.findElement(By.xpath("(//img)[7]")).click();
		Reporter.log("Excuting users test",true);
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		Reporter.log("Running in afterTest",true);
	}
	

}
