package feidiasantoniouacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {
	
		public IOSDriver driver;
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
			
			XCUITestOptions options = new XCUITestOptions();
			options.setDeviceName(AppiumTestConfig.getIOSDeviceName());
			String appPath = AppiumTestConfig.getIOSAppPath();
			if (!appPath.isBlank()) {
				options.setApp(appPath);
			}
			options.setPlatformVersion(AppiumTestConfig.getIOSPlatformVersion());
			options.setWdaLaunchTimeout(Duration.ofSeconds(20));
			
			driver = new IOSDriver(new URI(AppiumTestConfig.getAppiumServerUrl()).toURL(), options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}		

		@AfterClass
		public void tearDown() {
			driver.quit();
			service.stop(); 
		}
}
