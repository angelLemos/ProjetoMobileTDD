package br.com.rsinet.hub_tdd.testes;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.PageObject.TelaFormularioPage;
import br.com.rsinet.hub_tdd.PageObject.TelaInicialPage;
import br.com.rsinet.hub_tdd.PageObject.TelaLoginPage;
import br.com.rsinet.hub_tdd.PageObject.TelaMenuPage;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ReportConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TesteFormulario {

	private AndroidDriver<WebElement> driver;
	private TelaInicialPage telaInicial;

	private TelaMenuPage telaMenu;
	private TelaFormularioPage telaFormulario;
	private TelaLoginPage telaLogin;
	private ExtentReports extent;
	private String testName;
	private ExtentTest test;

	@BeforeTest
	public void setConfigReport() {
		//setando o reporte 
		ReportConfig.setReport();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = DriverFactory.criarDriver();
		PageFactory.initElements(driver, this);
		telaInicial = PageFactory.initElements(driver, TelaInicialPage.class);
		telaMenu = PageFactory.initElements(driver, TelaMenuPage.class);
		telaFormulario = PageFactory.initElements(driver, TelaFormularioPage.class);
		telaLogin = PageFactory.initElements(driver, TelaLoginPage.class);
		
		
	}

	@Test
	public void deveCadastrarUmUsuario() throws MalformedURLException, InterruptedException {

//		// report
//		testName = new Throwable().getStackTrace()[0].getMethodName();
////		test = extent.createTest(testName);
		
		// teste
		telaInicial.clicarMenu();
		telaMenu.clicarLogin();
		telaLogin.clicarNovaConta();
		
		telaFormulario.inserirUserName("angel");
		telaFormulario.inserirEmail();
		telaFormulario.inserirSenha("Agrte12");
		telaFormulario.confirmarSenha("Agrte12");
		telaFormulario.inserirNome("angelica");
		telaFormulario.inserirSobrenome("lemos");
		telaFormulario.inserirTelefone("0288937722");
		telaFormulario.inserirEstado("SP");
		telaFormulario.inserirEndereco("av.Cons Nebias");
		telaFormulario.inserirCidade("Santos");
		telaFormulario.inserirCep("11675289");
		telaFormulario.scroll();
		//telaFormulario.registrar();
//			.inserirNome("angelica");
//			.digitarEmail("angelica.@hotmail.com").enter()
//			.digitarSenha("Agrte12").enter()
//			.digitarReSenha("Agrte12").enter()
//			.digitarNome("angelica").enter()
//			.digitarSobreNome("lemos").enter()
//			.digitarTelefone("999876789").enter()
//			.digitarEstado("SP").enter()
//			.digitarEndereco("av. Cons.Nebias").enter()
//			.digitarCidade("santos").enter()
//			.digitarCep("11046787").enter()
//			.scroll()
//			.registrar();
//		telaInicial.clicarMenu();
//		
//		assertTrue(telaMenu.logado());

	}
}