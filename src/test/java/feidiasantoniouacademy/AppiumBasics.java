package feidiasantoniouacademy;


import java.net.MalformedURLException;

import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


@Test
public class AppiumBasics extends BaseTest {
	
	public void WifiSettingsName() throws MalformedURLException, URISyntaxException {
		
		// code to start server
		
		//AndroidDriver , iOSDriver
		//Appium code -> Appium Server -> Mobile
		//Actual automation starts
		//Xpath, id, accessibilityId, classname, androidUIAutomator
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		//set wifi name
		

	
		
	}

}
 