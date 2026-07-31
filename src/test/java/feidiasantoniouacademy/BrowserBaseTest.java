package feidiasantoniouacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {
	
		public AndroidDriver driver;
		public AppiumDriverLocalService service;
		
		@BeforeClass
		public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
			String appiumJsPath = AppiumTestConfig.getAppiumJsPath();
			AppiumServiceBuilder builder = new AppiumServiceBuilder()
					.withIPAddress(AppiumTestConfig.getAppiumHost())
					.usingPort(AppiumTestConfig.getAppiumPort());
			if (!appiumJsPath.isBlank()) {
				builder.withAppiumJS(new File(appiumJsPath));
			}
			service = builder.build();
			service.start();
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName(AppiumTestConfig.getAndroidDeviceName());
			String chromedriverPath = AppiumTestConfig.getChromedriverPath();
			if (!chromedriverPath.isBlank()) {
				options.setChromedriverExecutable(chromedriverPath);
			}
			options.setCapability("browserName", AppiumTestConfig.getBrowserName());
			
			driver = new AndroidDriver(new URI(AppiumTestConfig.getAppiumServerUrl()).toURL(), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		public Double getFormattedAmount(String amount) {
			Double price = Double.parseDouble(amount.substring(1));
			return price;
		}

		@AfterClass
		public void tearDown() {
			driver.quit();
			service.stop(); 
		}
}
