package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.TelaObject.TelaInicialObject;
import br.com.rsinet.hub_tdd.TelaObject.TelaProdutosObject;
import br.com.rsinet.hub_tdd.utils.ReportConfig;
import io.appium.java_client.android.AndroidDriver;

public class ConsultarProdutoLupa {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	private TelaInicialObject telaInicial;
	private TelaProdutosObject telaProduto;
	private ExtentTest test;

	@BeforeTest
	public void setConfigReport() {
		// setando o reporte
		ReportConfig.setReport();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = inicializarDriver();
		telaInicial = new TelaInicialObject(driver);
		telaProduto = new TelaProdutosObject(driver);
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void pesquisaProdutoCampo() throws InterruptedException {

		telaInicial.clicarLupa();
		telaInicial.escreverLupa("Laptops");
		telaInicial.clicarLupa();
		telaProduto.escolherProdutoNaTelaDeProduto("HP PAVILION 15Z TOUCH LAPTOP");
		WebElement element = driver.findElementById("com.Advantage.aShopping:id/textViewProductName");
		wait.until(ExpectedConditions.visibilityOf(element));
		
		// Utilizado thread para aguardar a imagem aparecer para screenshot
		Thread.sleep(2000);
		
		
		assertEquals(element.getText(), "HP PAVILION 15Z TOUCH LAPTOP");
		test = ReportConfig.createTest("pesquisaProdutoCampo");
	}

	@Test
	public void pesquisarProdutoInexistente() throws InterruptedException {
		telaInicial.clicarLupa();
		telaInicial.escreverLupa("smartphones");
		telaInicial.clicarLupa();
		WebElement element = driver.findElementById("com.Advantage.aShopping:id/textViewNoProductsToShow");
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "- No results for \"smartphones\" -");
		test = ReportConfig.createTest("pesquisarProdutoInexistente");
	}

	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		ReportConfig.statusReported(test, result, driver);

		// fechando
		fecharDriver();
	}

	@AfterTest
	public void finalizaReport() {
		ReportConfig.quitExtent();
	}
}