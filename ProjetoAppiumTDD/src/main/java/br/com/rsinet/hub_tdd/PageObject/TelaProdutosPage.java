package br.com.rsinet.hub_tdd.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaProdutosPage {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public TelaProdutosPage(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}
	
	public void produtoLupa() {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/RelativeLayoutProductControl']/child::*[0]").click();
	}
}
