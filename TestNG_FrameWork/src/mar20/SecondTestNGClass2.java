package mar20;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTestNGClass2 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		driver.findElement(By.name("Submit")).click();
		Reporter.log("Running in before method",true);
	}
	@Test (priority = 2, enabled = false)
	public void pim() 
	{
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
		Reporter.log("Executing pin test",true);
	}
	@Test (priority = 0, invocationCount = 10)// invocation method use for how many time you want to run the test case
	public void leave() 
	{
		driver.findElement(By.xpath("//b[normalize-space()='Leave']")).click();
		Reporter.log("Executing leave test",true);
	}
	@Test (priority = 1)
	public void admin() 
	{
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		Reporter.log("Executing admin test",true);
	}
	@AfterMethod
	public void tearDown()
	{
		Reporter.log("Running in After method",true);
		driver.quit();
	}

}