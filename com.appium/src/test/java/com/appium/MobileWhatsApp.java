package com.appium;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;

public class MobileWhatsApp {

	WebDriver driver;	
	
@Test
public void testApp() throws MalformedURLException, InterruptedException{
	
	//File app = new File ("C:\\ROCA\\Mine\\AppiumSettings\\whatsApp\\com.whatsapp_v2.16.120-451204_Android-2.1.apk");
	DesiredCapabilities capabilities= new DesiredCapabilities();
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("deviceName", "MotoE");
	capabilities.setCapability("platformVersion", "4.4.4");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appPackage", "com.android.calculator2");
	capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 
	//capabilities.setCapability("app", app.getAbsolutePath());
	/*capabilities.setCapability("appPackage", "com.whatsapp");
	capabilities.setCapability("appActivity", "com.whatsapp.Main");
	
	driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	Thread.sleep(1000);*/
	
	}
		
}	
		




