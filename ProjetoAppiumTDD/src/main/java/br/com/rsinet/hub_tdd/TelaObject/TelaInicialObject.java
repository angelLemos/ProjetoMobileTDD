package br.com.rsinet.hub_tdd.TelaObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaInicialObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@SuppressWarnings("unchecked")
	public TelaInicialObject(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}

	public void escreverLupa(String produto) {
		driver.findElementById("com.Advantage.aShopping:id/editTextSearch").click();
		driver.findElementById("com.Advantage.aShopping:id/editTextSearch").sendKeys(produto);

	}

	public void clicarLupa() {
		driver.findElementById("com.Advantage.aShopping:id/imageViewSearch").click();
	}

	public void clicarMenu() throws InterruptedException {
		Thread.sleep(3000);
//		wait.pollingEvery(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.Advantage.aShopping:id/imageViewMenu")));
		driver.findElementById("com.Advantage.aShopping:id/imageViewMenu").click();

	}

	public void clicarProdutoTela(String categoria ) {
		driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'"+categoria+"')]").click();
	}
}
