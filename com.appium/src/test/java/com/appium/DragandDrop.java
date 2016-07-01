package com.appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragandDrop {
	
	WebDriver driver;
	String resultsPath="C:\\ROCA\\Mine\\AppiumWS\\com.appium\\Results";
	
	@BeforeTest
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		String filePath="C:\\ROCA\\Mine\\AppiumWS\\com.appium\\Apps\\com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk";
		
		
		
		File app=new File(filePath);
		
		/*File classRoot=new File(System.getProperty("user.dir"));
		File appDir = new File(classRoot, "/Apps");*/
		
	
		
		//File app = new File(appDir, "com.mobeta.android.demodslv-0.5.0-3_APKdot.com.apk");  
		
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, "2.3.4");
		capabilities.setCapability("deviceName", "Sony");
		capabilities.setCapability("platformName", "Andorid");
			
		capabilities.setCapability("browserName", "Android");
		

		  //Set .apk file's path capabilities.
		  capabilities.setCapability("app", app.getAbsolutePath());
		  
		  System.out.println(app.getAbsolutePath());

		  // Set app Package desired capability of Drag-Sort Demos app.
		  capabilities.setCapability("appPackage", "com.mobeta.android.demodslv");

		  // Set app Activity desired capability of Drag-Sort Demos app.
		  capabilities.setCapability("appActivity", "com.mobeta.android.demodslv.Launcher");

		  // Created object of AndroidDriver and set capabilities.
		  // Set appium server address and port number in URL string.
		  // It will launch Drag-Sort Demos app in emulator.
		  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
	}
	
	
	@Test
	 public void dragDrop() throws IOException, InterruptedException {
	  //Tap on Basic usage Playground.
		
		driver.findElements(By.className("android.widget.LinearLayout")).get(0).click();
	
		
		WebElement ele1=driver.findElements(By.className("android.widget.LinearLayout")).get(0);
		
		WebElement ele2=driver.findElements(By.className("android.widget.LinearLayout")).get(6);

	  /*//Locate 3rd element(Chick Corea) from list to drag.
	  WebElement ele1 = (WebElement) ((RemoteWebDriver) driver).findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(2);
	  //Locate 6th element to drop dragged element.
	  WebElement ele2 = (WebElement) ((RemoteWebDriver) driver).findElementsById("com.mobeta.android.demodslv:id/drag_handle").get(5);*/

	  //Perform drag and drop operation using TouchAction class.
	  //Created object of TouchAction class.
	  TouchAction action = new TouchAction((MobileDriver) driver);
	  
	  System.out.println("It Is dragging element.");
	  //It will hold tap on 3rd element and move to 6th position and then release tap.
	  action.longPress(ele1).moveTo(ele2).release().perform();  
	  
	  Thread.sleep(10000);
	  
	  //generate string result id
	  
	  int num=SampleJavaCode.randInt();
	  
	  WebDriver driver1 = new Augmenter().augment(driver);
	  File file  = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file, new File(resultsPath+"Screenshot"+num+".jpg"));
	  
	  System.out.println("Element has been droped at destination successfully.");
	 }
	
	

	
	@AfterTest
	 public void End() {
	  // Quit
	  driver.quit();
	 }
}
