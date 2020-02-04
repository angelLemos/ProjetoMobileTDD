package br.com.rsinet.hub_tdd.PageObject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class metodosPage {

		private AndroidDriver<MobileElement> driver;
		protected TouchAction<?> touchAction;
		
		public metodosPage(AndroidDriver<MobileElement> driver) {
			this.driver = driver;
		}
		
		public metodosPage(AndroidDriver<MobileElement> driver, TouchAction<?> touchAction) {
			this.driver = driver;
			this.touchAction = touchAction;
		}
		
		public void scrollAteElementoClicavel(String visibleText) {
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ visibleText + "\").instance(0))")
					.click();
		}
		
	}

