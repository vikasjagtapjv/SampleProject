package com.sampleProject.Qa.TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleCheckBox {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	@Test(priority=0)
	public void handleSingleCheckBox()
	{
		driver.findElement(By.xpath("//input[@value='blue']")).click();
	}
	@Test(priority=1)
	public void handleMultipleCheckBoxes()
	{
		List<WebElement> CheckBOxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println(CheckBOxes.size());
//		for(int i=0;i<CheckBOxes.size();i++)
//		{
//			CheckBOxes.get(i).click();
//			
//		}
		for(WebElement ele:CheckBOxes)
		{
			ele.click();
		}
		
		
	}
	@Test(priority=2)
	public void handleRandomCheckBoxes()
	{
		List<WebElement> randomBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement randomCheck:randomBoxes)
		{
			String AttributeValue=randomCheck.getAttribute("value");
			if(AttributeValue.equals("blue")||AttributeValue.equals("Orange"))
			{
				randomCheck.click();
			}
		}
		
	}
	@Test(priority=3)
	public void selectTopCheckBoxes()
	{
		List<WebElement> randomBoxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(int i=0;i<randomBoxes.size();i++)
		{
			if(i>2)
			{
				randomBoxes.get(i).click();	
			}
		}

	}
}
