package com.sampleProject.Qa.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class Headlsess_Execution {
	@Test
	public void testHeadless()
	{
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--headless");
		
		FirefoxOptions options1=new FirefoxOptions();
		options1.addArguments("--headless");
		WebDriver driver=new FirefoxDriver(options1);
		//WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.google.com/");
	}

}
