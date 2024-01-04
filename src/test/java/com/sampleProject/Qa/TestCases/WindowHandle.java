package com.sampleProject.Qa.TestCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
	//	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		 String S=driver.getWindowHandle();
		 System.out.println(S);
		JavascriptExecutor jre=(JavascriptExecutor)driver;
		jre.executeScript("window.scrollBy(0,600)");
		WebElement ele=driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']"));
		ele.click();
		String childTitle=driver.getTitle();
		System.out.println(childTitle);
		Set<String>id=driver.getWindowHandles();
		
//		Iterator<String>it=id.iterator();
//		String parentId=it.next();
//		String childId=it.next();
//		System.out.println("parent id is :"+parentId);
//		System.out.println("child id is :"+childId);
//		driver.switchTo().window(parentId);
//		String parentTitle=driver.getTitle();
//		System.out.println(parentTitle);
		
		for(String Id:id)
		{
			String Title=driver.switchTo().window(Id).getTitle();
			if(Title.equals("OrangeHRM")
					||Title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
			{
				driver.close();
			}
		}
	}

}
