package feidiasantoniouacademy;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class IOSBasics extends IOSBaseTest {
	
	@Test
	public void IOSBasicsTest() {
		
		//XPath, className, IOS, iosClassChain, IOSPredicateString, accessibilityId, Id
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
	}
}
