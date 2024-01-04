package com.sampleProject.Qa.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
	@Test
	public void validWithValidCredentials()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get("https://tutorialsninja.com/demo/");
		
		

     }
}
