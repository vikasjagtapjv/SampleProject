package com.sampleProject.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> ListOfLinks = driver.findElements(By.tagName("a"));

		System.out.println("all links :" + ListOfLinks.size());
		int responseC = 200;
		int BrokenLinks = 0;
		for (WebElement ele : ListOfLinks) {
			String url = ele.getAttribute("href");
			try {
				URL urllink = new URL(url);

				HttpURLConnection huc = (HttpURLConnection) urllink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();

				responseC = huc.getResponseCode();
				if (responseC >= 400) {
					System.out.println(" Broken links are as follows :" + url);
					BrokenLinks++;
				}

			} catch (MalformedURLException e) {

				e.printStackTrace();
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		System.out.println(BrokenLinks);
	}

}
