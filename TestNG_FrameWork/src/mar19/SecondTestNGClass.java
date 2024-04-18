package mar19;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTestNGClass {
	WebDriver driver;
	@BeforeMethod
	public void setUp() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.calculator.net/math-calculator.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Running in before method",true);
	}
	@Test
	public void add() 
	{
		driver.findElement(By.xpath("//span[normalize-space()='7']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='+']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='8']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='=']")).click();
		String addation= driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
		Reporter.log("Executing Addition::"+addation,true);
	}
	@Test
	public void div() 
	{
		driver.findElement(By.xpath("//span[normalize-space()='8']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='÷']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='2']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='=']")).click();
		String division= driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
		Reporter.log("Executing Division::"+division,true);
	}
	@Test
	public void mul() 
	{
		driver.findElement(By.xpath("//span[normalize-space()='7']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='×']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='8']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='=']")).click();
		String multiplication= driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText();
		Reporter.log("Executing Multiplication::"+multiplication,true);
	}
	@AfterMethod
	public void tearDown()
	{
		Reporter.log("Running in After method",true);
		driver.quit();
	}

}
