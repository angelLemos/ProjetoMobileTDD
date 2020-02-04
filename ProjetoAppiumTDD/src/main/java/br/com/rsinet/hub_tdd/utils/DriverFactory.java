package br.com.rsinet.hub_tdd.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {
	private static AndroidDriver<WebElement> driver;

	private DriverFactory() {
		
	}

	@SuppressWarnings("unused")
	public static AndroidDriver<WebElement> criarDriver() throws MalformedURLException {
		if(driver == null) {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability("appPackage", "com.Advantage.aShopping");
		desiredCapabilities.setCapability("appActivity", "com.Advantage.aShopping.SplashActivity");
		desiredCapabilities.setCapability("unicodeKeyboard", true);
		desiredCapabilities.setCapability("resetKeyboard", true);

		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		return driver;
	}

	public static void fecharDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}

