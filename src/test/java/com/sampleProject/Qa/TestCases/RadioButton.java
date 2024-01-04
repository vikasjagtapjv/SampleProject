 package com.sampleProject.Qa.TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
	public static void main(String[] args) {
		//creating WebDriver instance and cast it to different browser classes by using reference variable driver 
		//then we can use different method of WebDriver interfaces like get(),getTitle(),close() 
		WebDriver driver=new ChromeDriver();
		//so we can import the important packages of interfaces and classes
		/*
		 * now here we are using one application to handle the radio button
		 * https://www.facebook.com/
		 * //input[@class='_8esa']
		 */
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[contains(@data-testid,'open-registration-form-button')]")).click();
	
		//driver.findElement(By.xpath("//input[@value='1']")).click();
		List<WebElement>buttons=driver.findElements(By.xpath("//label[@class='_58mt']"));
		System.out.println(buttons.size());
//		for(int i=0;i<buttons.size();i++)
//		{
//			String s=buttons.get(i).getText();
//			System.out.println(s);
//			if(buttons.get(i).getText().equalsIgnoreCase("Male"))
//			{
//				buttons.get(i).click();
//				break;
//			}
//		}
		
		for(WebElement ele:buttons)
		{
			String str=ele.getAttribute("class");
			System.out.println(str);
			String s=ele.getText();
			System.out.println(s);		}
	}

}
