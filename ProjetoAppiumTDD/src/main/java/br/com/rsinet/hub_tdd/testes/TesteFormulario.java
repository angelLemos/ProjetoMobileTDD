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
import br.com.rsinet.hub_tdd.utils.Scroll;
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
	private Scroll scroll;

	@BeforeTest
	public void setConfigReport() {
		//setando o reporte 
		ReportConfig.setReport();
	}

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		driver = DriverFactory.criarDriver();
		telaInicial = new TelaInicialPage(driver);
		telaMenu = new TelaMenuPage(driver);
		telaFormulario = new TelaFormularioPage(driver);
		telaLogin = new TelaLoginPage(driver);
		scroll = new Scroll(driver);
	
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
		
		telaFormulario.inserirUserName("angel9054");
		telaFormulario.inserirEmail("angelica@hotmail.com");
		telaFormulario.inserirSenha("Agrte12");
		telaFormulario.confirmarSenha("Agrte12");
		telaFormulario.inserirNome("angelica");
		telaFormulario.inserirSobrenome("lemos");
		telaFormulario.inserirTelefone("0288937722");
		scroll.scrollSelecionarPais();
		telaFormulario.selecionarPais(driver, "Brazil");
		telaFormulario.inserirEstado("SP");
		telaFormulario.inserirEndereco("av.Cons Nebias");
		telaFormulario.inserirCidade("Santos");
		telaFormulario.inserirCep("11675289");
		scroll.scrollParaRegistrar();
		telaFormulario.registrar();
		//telaInicial.clicarMenu();		
	}
}