package feidiasantoniouacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

@Test
public class AppiumBasics {
	
	public void AppiumTest() throws MalformedURLException, URISyntaxException {
		
		// code to start server
		
		//AndroidDriver , iOSDriver
		//Appium code -> Appium Server -> Mobile
		
		AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\feidi\\\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Feidiasemulator"); //emulator
		options.setApp("C:\\Users\\feidi\\eclipse\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		//Actual automation starts
		//Xpath, id, accessibilityId, classname, androidUIAutomator
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.quit();
		service.stop(); //stop server
	
		
	}

}
 