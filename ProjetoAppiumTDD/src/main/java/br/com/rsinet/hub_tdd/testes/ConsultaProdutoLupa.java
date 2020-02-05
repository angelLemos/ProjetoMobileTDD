package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.PageObject.TelaInicialPage;
import br.com.rsinet.hub_tdd.PageObject.TelaProdutosPage;
import io.appium.java_client.android.AndroidDriver;

public class ConsultaProdutoLupa {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	
	private TelaInicialPage telaInicial;
	private TelaProdutosPage telaProduto;
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = inicializarDriver();
		telaInicial = new TelaInicialPage(driver);
		wait = new WebDriverWait(driver, 30);
	}
	@Test
	public void pesquisaProdutoCampo() {
	
		telaInicial.clicarLupa();
		telaInicial.escreverLupa("Laptops");
		telaInicial.clicarLupa();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.RelativeLayout[@content-desc=\\\"Search\\\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[4]")));
		telaProduto.produtoLupa();
//		telaListaProdutos.SelecionarProdutoDoCampo();
//		js = (JavascriptExecutor) driver;
//        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000);");
//		Assert.assertEquals("http://www.advantageonlineshopping.com/#/product/11?viewAll=Laptops", driver.getCurrentUrl());
//		test = ReportConfig.createTest("pesquisaProdutoCampo");
	}
	
//	@Test
//	public void pesquisarProdutoInexistente() throws InterruptedException {
//
//		telaInicial.clicarNaLupa();
//		telaInicial.inserirProduto("smartphones");
//		js = (JavascriptExecutor) driver;
//		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
//		
//		String textoElement = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/section[1]/article[1]/div[3]/div[1]/label[1]/span[1]")).getText();
//		assertEquals(textoElement, "No results for \"smartphones\"");

}

