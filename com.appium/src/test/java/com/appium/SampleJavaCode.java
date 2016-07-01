package com.appium;

import java.util.Random;

public class SampleJavaCode {

	public static int randInt(){
		
		int randomNum = 100 + (int)(Math.random() * 100);
		
		System.out.println(randomNum);
		return randomNum;
		
	}

}
