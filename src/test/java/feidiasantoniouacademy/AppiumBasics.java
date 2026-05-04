package feidiasantoniouacademy;


import java.net.MalformedURLException;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
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
		
		//tagName[@attribute='value'] -> //tagName
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\'3. Preference dependencies\']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout) [2]")).click();
		//set wifi name
		

	
		
	}

}
 