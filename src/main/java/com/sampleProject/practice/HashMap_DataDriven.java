package com.sampleProject.practice;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashMap_DataDriven {
	public static void main(String args[])
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String credentials=mapData().get("User1");
		driver.findElement(By.name("username")).sendKeys(credentials.split(":")[0]);
		driver.findElement(By.name("password")).sendKeys(credentials.split(":")[1]);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.close();
	}
	public static HashMap<String, String> mapData()
	{
		HashMap<String, String>mp=new HashMap<String, String>();
		mp.put("User1","Admin:admin123");
		mp.put("User2","admin:Admin123");
		mp.put("User3","admin:admin123");
		mp.put("User4","Admin:Admin123");
		mp.put("User5","dmin123:Admin");
		mp.put("User6","Admin123:admin");
		mp.put("User7","Admin123:Admin123");
		mp.put("User8","admin123:admin123");
		mp.put("User9","Admin:Admin");
		mp.put("User10","admin:Admin");
		mp.put("User11","Admin:admin");
		return mp;
	}

}
