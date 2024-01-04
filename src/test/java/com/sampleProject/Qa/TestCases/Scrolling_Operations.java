package com.sampleProject.Qa.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Scrolling_Operations {
	public static WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	@Test(priority=0)
	public void javascriptScroll() throws Exception
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		
		JavascriptExecutor jre=(JavascriptExecutor)driver;
		//jre.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		jre.executeScript("window.scrollBy(0,700)");

		Thread.sleep(5000);
		jre.executeScript("window.scrollBy(0,-700)");
		
	}
	@Test(priority=1)
	public void actiosScroll() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(5000);
		Actions act =new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);
		act.sendKeys(Keys.PAGE_UP).build().perform();

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
