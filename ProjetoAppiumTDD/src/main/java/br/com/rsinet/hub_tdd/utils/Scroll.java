package br.com.rsinet.hub_tdd.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Scroll {
	@SuppressWarnings("rawtypes")
	private TouchAction touch;
	private AndroidDriver<WebElement> driver;

	@SuppressWarnings("rawtypes")
	public Scroll(AndroidDriver<WebElement> driver) {
	        this.driver = driver;
	        this.touch = new TouchAction(this.driver);
	    }

	public void scrollBotaoRegistrar() {
		touch.press(PointOption.point(1051, 1773)).moveTo(PointOption.point(1042, 353)).release().perform();
	}

}
