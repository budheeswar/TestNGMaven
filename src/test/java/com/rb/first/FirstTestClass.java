package com.rb.first;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FirstTestClass {

	@Test
	public void testGoogle() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("selenium java", Keys.ENTER);
        //System.out.println(driver.getTitle());
        String expectedTitle="selenium java - Google Search";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle); // if this fails driver.quit wont execute as we using hard assertions        
        driver.quit();
        //System.out.println("test Google Executed");
		
	}
	@Test
	public void testFacebook() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("facebook@email", Keys.ENTER);
		//driver.findElement(By.name("pass")).sendKeys("facebook@email", Keys.ENTER);
		
        //System.out.println(driver.getTitle());
        //Thread.sleep(5000);
		SoftAssert softAssert=new SoftAssert();
		String actualTitle=driver.getTitle();
		String expectedTitle="Facebook - log in or sign up";
		softAssert.assertEquals(expectedTitle, actualTitle);
		softAssert.assertEquals("same","same");
		//softAssert.assertEquals("different","same","string mismatch");
        driver.quit();
        System.out.println("testFacebook Executed");
        softAssert.assertAll();
	}
	
}
