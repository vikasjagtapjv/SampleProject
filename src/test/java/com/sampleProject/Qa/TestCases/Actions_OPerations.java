package com.sampleProject.Qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Actions_OPerations {
	public static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
	}
	@Test
	public void mouseHover()
	{
		driver.findElement(By.xpath("//span[@role='button']")).click();
		WebElement elc=driver.findElement(By.xpath("//span[text()='Electronics']"));
		elc.click();
		WebElement elc1=driver.findElement(By.xpath("//span[text()='Electronics']"));
		Actions act=new Actions(driver);
		act.moveToElement(elc1).build().perform();
	}
	@Test
	public void contexclick()
	{
		driver.findElement(By.xpath("//span[@role='button']")).click();
		WebElement appli=driver.findElement(By.xpath("//span[text()='TVs & Appliances']"));
		Actions act=new Actions(driver);
		act.contextClick(appli).build().perform();
	}
	@Test
	public void doubleClick()
	{
		driver.findElement(By.xpath("//span[@role='button']")).click();
		WebElement groc=driver.findElement(By.xpath("//span[text()='Grocery']"));
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();

		act.doubleClick(groc).build().perform();

	}
	@Test
	public void scrollPage() throws Exception
	{
		driver.findElement(By.xpath("//span[@role='button']")).click();
		WebElement groc=driver.findElement(By.xpath("//span[text()='Grocery']"));
		groc.click();
		//Actions act=new Actions(driver);
		Thread.sleep(5000);
		//act.sendKeys(Keys.PAGE_DOWN).build().perform();
		JavascriptExecutor jre=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].scrollIntoView();", Element);
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		jre.executeScript("window.scrollBy(0,1200)");
		WebElement ele=driver.findElement(By.xpath("//a[text()='Contact Us']"));
		String s=ele.getText();
		System.out.println("captured text is :"+s);
		
	}
	

}
