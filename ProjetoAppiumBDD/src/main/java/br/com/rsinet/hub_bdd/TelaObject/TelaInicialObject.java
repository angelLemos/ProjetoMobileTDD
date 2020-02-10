package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

	@FindBy(id = "com.Advantage.aShopping:id/imageViewMenu")
	private WebElement btnClicarMenu;
	
	@FindBy(id = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement btnEscreverLupa;

	@FindBy(id = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement btnClicarLupa;
	
	@FindBy(xpath = "//android.widget.TextView[starts-with(@text,'SPEAKERS')]")
	private WebElement lnkClicarEmCategoriaHome;


	public void escreverLupa(String produto) {
		btnEscreverLupa.click();
		btnEscreverLupa.sendKeys(produto);

	}

	public void clicarLupa() {
		btnClicarLupa.click();
		
	}
	public void clicarMenu() throws InterruptedException {
		Thread.sleep(3000);
//		wait.pollingEvery(Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(btnClicarMenu));
		btnClicarMenu.click();

	}
	
	public void clicarProdutoTela() {
		
		lnkClicarEmCategoriaHome.click();
		
	}

}
