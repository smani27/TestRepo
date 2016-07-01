package com.appium;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class LaunchBrowser {
	
	private AndroidDriver driver;
 
  @BeforeTest
  public void setUp() {
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  
	  capabilities.setCapability("deviceName", "MotoE");
	  
	  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	  
	  capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
	  
	  capabilities.setCapability("platformName", "Android");
	  
	  capabilities.setCapability("appPackage", "com.android.chrome");
	  
	  capabilities.setCapability("appActivity", "com.google.android.apps.chrome.ChromeTabbedActivity");
	  
	  try {
		driver=new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"),capabilities);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  @Test
  public void launchBrowser() throws InterruptedException {
	  
	  driver.get("http://www.google.com");
	  
	  driver.findElement(By.name("q")).sendKeys("Hello World");
	  
	  driver.findElement(By.id("btnK")).click();
	  
	 
	    Thread.sleep(5000);
	  
  }

  @AfterTest
  public void tearDown() {
	  
	  driver.quit();
	  
  }

}
