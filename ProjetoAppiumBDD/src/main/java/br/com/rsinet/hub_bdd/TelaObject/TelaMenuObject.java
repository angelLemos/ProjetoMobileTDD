package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaMenuObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public TelaMenuObject(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}
//
//	@FindBy(id = "com.Advantage.aShopping:id/textViewMenuUser")
//	private WebElement login;
//	
//	@FindBy(id = "com.Advantage.aShopping:id/textViewMenuSignOut")
//	private WebElement logOut;
//	
//	@FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
//	private WebElement menu;
//	
//	public void abrir() {
//		menu.click();
//	}

	public void clicarLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("com.Advantage.aShopping:id/imageViewMenu")));
		driver.findElementById("com.Advantage.aShopping:id/textViewMenuUser").click();
	}
	
//	public boolean logado() {
//		try {
//			return logOut.isDisplayed();
//		} catch (Exception e) {
//			return false;
//		}
//	}

}

