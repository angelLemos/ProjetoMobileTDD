package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static br.com.rsinet.hub_tdd.utils.DriverFactory.inicializarDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import br.com.rsinet.hub_tdd.TelaObject.TelaLoginObject;
import br.com.rsinet.hub_tdd.TelaObject.TelaMenuObject;
import br.com.rsinet.hub_tdd.TelaObject.TelaProdutosObject;
import br.com.rsinet.hub_tdd.utils.ExcelDadosConfig;
import br.com.rsinet.hub_tdd.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.utils.ReportConfig;
import br.com.rsinet.hub_tdd.utils.Scroll;
import io.appium.java_client.android.AndroidDriver;

public class ConsultarProdutoHome {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	private TelaInicialObject telaInicial;
	private TelaProdutosObject telaProduto;
	private Scroll scroll;
	private TelaMenuObject telaMenu;
	private TelaLoginObject telaLogin;
	private MassaDeDados excel;
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
		scroll = new Scroll(driver);
		wait = new WebDriverWait(driver, 30);
		telaLogin = new TelaLoginObject(driver);
		telaMenu = new TelaMenuObject(driver);
		// nome da planilha no excel
		ExcelDadosConfig.setExcelFile("Planilha1");
		// Instanciando a massa de dados
		excel = new MassaDeDados();

	}

	@Test
	public void pesquisaProdutoTela() {

		telaInicial.clicarNaOpcaoTelaHome("HEADPHONES");
		telaProduto.escolherProdutoNaTelaDeProduto("LOGITECH USB HEADSET H390");
		WebElement element = driver.findElementById("com.Advantage.aShopping:id/textViewProductName");
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), "LOGITECH USB HEADSET H390");
		test = ReportConfig.createTest("pesquisaProdutoTela");

	}

	@Test
	public void validandoQuantidadeErrada() throws Exception {
		telaInicial.clicarMenu();
		telaMenu.clicarLogin();
		telaLogin.clicarEmUserName(excel.getUserName());
		telaLogin.clicarEmPassword(excel.getSenha());
		telaLogin.clicarEmLogin();

		scroll.scroolTelaHome("SPEAKERS");
		telaProduto.escolherProdutoNaTelaDeProduto("HP ROAR MINI WIRELESS SPEAKER");
		telaProduto.clicarEmQuantidade();
		telaProduto.escolherQuantidades("15");
		telaProduto.confirmarQuantidadeDeProdutos();
		telaProduto.adicionarNoCarrinho();
		assertTrue(driver.getPageSource().contains("10"));
		test = ReportConfig.createTest("validandoQuantidadeErrada");

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
