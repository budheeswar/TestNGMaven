package com.rb.second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamAnotationLoginEx {
	WebDriver driver;
    //Dont Run this Code run ParamAnotTestNG.xml 
	@Parameters({"name" , "password"}) // getting value from ParamAnotTestNG.xml to java code
	@Test
	public void testLogin(String name, String password) {
		driver.findElement(By.id("username")).sendKeys(name);//value got from xml
		driver.findElement(By.id("password")).sendKeys(password);//got from xml
		driver.findElement(By.id("submit")).click();
		System.out.println("name "+name+" password "+password);
		System.out.println("Login Test Executed");
	}

	@Parameters("url")
	@BeforeMethod
	public void initializeChrome(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		System.out.println(url);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
