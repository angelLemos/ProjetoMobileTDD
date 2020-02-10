package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaProdutosObject {
	private AndroidDriver<WebElement> driver;
	@SuppressWarnings("unused")
	private WebDriverWait wait;

	@SuppressWarnings("unchecked")
	public TelaProdutosObject(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}
//	
//	public void produtoLupa() {
//		driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'HP PAVILION 15Z TOUCH LAPTOP')]").click();
//	}
//	
//	public void produtoTela() {
//		driver.findElementByXPath("//android.widget.TextView[starts-with(@text,'LOGITECH USB HEADSET H390')]").click();
//	}
	
	public void escolherProdutoNaTelaDeProduto(String nomeProduto) {
	    driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '"+nomeProduto+"')]").click();
	}
	
	public void clicarEmQuantidade() {
		driver.findElementByXPath("//android.widget.TextView[starts-with(@text, '1')]").click();
	}
	
	public void escolherQuantidades(String digiteAQuantidade) {
		driver.findElementById("com.Advantage.aShopping:id/textViewProductQuantity").clear();
		driver.findElementById("com.Advantage.aShopping:id/textViewProductQuantity").sendKeys(digiteAQuantidade);
	}
	
	public void confirmarQuantidadeDeProdutos() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.Advantage.aShopping:id/textViewApply")));
		driver.findElementById("com.Advantage.aShopping:id/textViewApply").click();
	}
	
	public void adicionarNoCarrinho() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.Advantage.aShopping:id/buttonProductAddToCart")));
		driver.findElementById("com.Advantage.aShopping:id/buttonProductAddToCart").click();
	}
	
	
	
//	public void clicarFiltro() {
//		 driver.findElementByXPath("//android.widget.TextView[starts-with(@text, 'FILTERS')]").click();
//	}
//	
//	public void telaFiltro() {
//		 driver.findElementByXPath("//android.widget.TextView[starts-with(@text, 'BY PRICE')]").click();
//	}
}
