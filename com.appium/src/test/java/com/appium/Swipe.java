package com.appium;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Swipe {
	
	AndroidDriver driver;
	Dimension size;
  
  @BeforeClass
  public void setUp() throws MalformedURLException {
	  
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  
	  capabilities.setCapability("deviceName", "MotoE");
	  capabilities.setCapability("platformName", "Android");
	  capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	  capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
	  
	  // to verify the app package and activity use APK info file
	  capabilities.setCapability("appPackage", "com.fortysevendeg.android.swipelistview");
	  capabilities.setCapability("appActivity","com.fortysevendeg.android.swipelistview.sample.activities.SwipeListViewExampleActivity");
	  
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	  WebDriverWait wait = new WebDriverWait(driver, 300);
	  wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.RelativeLayout")));
 
  }
  
  
  @Test
  public void swipeVertical() {
	  
	  // get the size of screen 
	  
	  size=driver.manage().window().getSize();
	  
	  
	  System.out.println(size);
	  
	  int startPt=(int) (size.height*0.80);
	  
	  int endPt=(int) (size.height*0.20);
	  
	  //find vertical point to swipe
	  
	//Find vertical point where you wants to swipe. It is in middle of screen height.
	  int starty = size.width / 2;
	  System.out.println("startx = " + startPt + " ,endx = " + endPt + " , starty = " + starty);
	  
	  //Swipe from Right to Left.
	  
	  driver.swipe(startPt, starty, endPt, starty, 3000);
	  
	  //swipe from left to right
	  
	  driver.swipe(endPt, starty, startPt, starty, 3000);
	  
	  
  }
  
  /*@Test
	public void swipeHorizontally(){
	  
	  //get size of screen
	  
	  size=driver.manage().window().getSize();
	  
	  System.out.println(size);
	  
	  int startx=(int) (size.width*0.80);
	  int endx=(int) (size.width*0.20);
	  
	  //horizontal mid point
	  
	  int midpoint=size.width/2;
	  
	  System.out.println(midpoint);
	  
	  //top to down
	  
	  driver.swipe(startx, midpoint, endx, midpoint, 3000);
	  
	  //down to top
	  
	  driver.swipe(endx, midpoint, startx, midpoint, 3000);
	  
  }
  */

  @AfterClass
  public void tearDown() {
	  
	  driver.quit();
  }

}
