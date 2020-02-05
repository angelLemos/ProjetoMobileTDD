package br.com.rsinet.hub_tdd.testes;

import static br.com.rsinet.hub_tdd.utils.DriverFactory.fecharDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.PageObject.TelaFormularioPage;
import br.com.rsinet.hub_tdd.PageObject.TelaInicialPage;
import br.com.rsinet.hub_tdd.PageObject.TelaLoginPage;
import br.com.rsinet.hub_tdd.PageObject.TelaMenuPage;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ExcelDadosConfig;
import br.com.rsinet.hub_tdd.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.utils.ReportConfig;
import br.com.rsinet.hub_tdd.utils.Scroll;
import io.appium.java_client.android.AndroidDriver;

public class TesteFormulario {

	private AndroidDriver<WebElement> driver;
	private TelaInicialPage telaInicial;

	private TelaMenuPage telaMenu;
	private TelaFormularioPage telaFormulario;
	private TelaLoginPage telaLogin;
	private Scroll scroll;
	private WebDriverWait wait;
	private MassaDeDados excel;

	@BeforeTest
	public void setConfigReport() {
		// setando o reporte
		ReportConfig.setReport();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.inicializarDriver();
		telaInicial = new TelaInicialPage(driver);
		telaMenu = new TelaMenuPage(driver);
		telaFormulario = new TelaFormularioPage(driver);
		telaLogin = new TelaLoginPage(driver);
		scroll = new Scroll(driver);
		// nome da planilha no excel
		ExcelDadosConfig.setExcelFile("Planilha1");
		// Instanciando a massa de dados
		excel = new MassaDeDados();

		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void deveCadastrarUmUsuario() throws Exception {
		telaInicial.clicarMenu();
		telaMenu.clicarLogin();
		telaLogin.clicarNovaConta();

		telaFormulario.inserirUserName(excel.getUserName());
		telaFormulario.inserirEmail(excel.getEmail());
		telaFormulario.inserirSenha(excel.getSenha());
		telaFormulario.confirmarSenha(excel.getConfirmarSenha());
		telaFormulario.inserirNome(excel.getNome());
		telaFormulario.inserirSobrenome(excel.getSobrenome());
		telaFormulario.inserirTelefone(excel.getTelefone());
		scroll.scrollBotaoRegistrar();
		telaFormulario.selecionarPais(driver, excel.getPais());
		telaFormulario.inserirEstado(excel.getEstado());
		telaFormulario.inserirEndereco(excel.getEndereco());
		telaFormulario.inserirCidade(excel.getCidade());
		telaFormulario.inserirCep(excel.getCEP());
		scroll.scrollBotaoRegistrar();
		telaFormulario.registrar();
		telaInicial.clicarMenu();
		WebElement element = driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		wait.until(ExpectedConditions.visibilityOf(element));
		assertEquals(element.getText(), excel.getUserName());
	}
	
	@Test
	public void validarBotaoRegistrarDesabilitadoSemDadosPreenchidos() throws Exception {
		telaInicial.clicarMenu();
		telaMenu.clicarLogin();
		telaLogin.clicarNovaConta();
		telaFormulario.inserirEmail(excel.getEmail());
		scroll.scrollBotaoRegistrar();
		assertFalse(telaFormulario.verificarSeRegistrarEstaDisponivel());
	}
	
	@AfterMethod
	public void finaliza(ITestResult result) throws IOException {
		fecharDriver();
	}
}
