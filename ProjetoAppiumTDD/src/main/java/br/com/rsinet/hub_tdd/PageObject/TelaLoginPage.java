package br.com.rsinet.hub_tdd.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaLoginPage {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public TelaLoginPage(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}

//		@FindBy(id = "com.Advantage.aShopping:id/textViewSingUpToday")
//		private WebElement lnkclicarEmNovaConta;

		public void clicarNovaConta() {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("com.Advantage.aShopping:id/textViewDontHaveAnAccount")));
			driver.findElementById("com.Advantage.aShopping:id/textViewDontHaveAnAccount").click();
		}

	}
