package br.com.rsinet.hub_tdd.TelaObject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaInicialObject{
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public TelaInicialObject(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}

//	@FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
//	private WebElement menu;
//	
//	@FindBy(id = "com.Advantage.aShopping:id/editTextSearch")
//	private WebElement busca;
//
//	@FindBy(id = "com.Advantage.aShopping:id/imageViewSearch")
//	private WebElement lupa;
//
//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView")
//	private WebElement opcaoNotebook;
//	
//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.TextView")
//	private WebElement opcaoFone;
//
//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.TextView")
//	private WebElement opcaoTablete;
//
//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.TextView")
//	private WebElement opcaoSom;
//
//	@FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[5]/android.widget.TextView")
//	private WebElement opcaoMouse;

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
	
	public void clicarProdutoTela() {
		driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'SPEAKERS')]").click();
	}

	public void clicarNaOpcaoTelaHome(String Categoria) {
		switch (Categoria) {
		case "LAPTOPS":
			driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView").click();
			break;
		case "HEADPHONES":
			driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'HEADPHONES')]").click();
			break;
		case "TABLETS":
			driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\\\"Home Page\\\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.TextView").click();
			break;
			case "SPEAKERS":
				driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'SPEAKERS')]").click();
		default:
			System.out.println("Produto nao encontrado!");
			break;
		}
	}

}
