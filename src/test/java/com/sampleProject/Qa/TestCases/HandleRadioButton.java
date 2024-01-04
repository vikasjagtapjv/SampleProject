package com.sampleProject.Qa.TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleRadioButton {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
//		WebElement ele=driver.findElement(By.xpath("//input[@value='2']"));
//		ele.click();
		List<WebElement>ele=driver.findElements(By.xpath("//label[@class='_58mt']"));
		System.out.println(ele.size());
		for(int i=0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("male"))
			{
				ele.get(i).click();
				break;
			}
		}
	}

}
