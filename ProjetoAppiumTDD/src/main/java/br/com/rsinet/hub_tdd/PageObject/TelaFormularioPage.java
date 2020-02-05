package br.com.rsinet.hub_tdd.PageObject;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.utils.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class TelaFormularioPage {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@SuppressWarnings("unchecked")
	public TelaFormularioPage(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}
//	@FindBy(className = "android.widget.RelativeLayout")
//	private List<WebElement> elementos;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
//	private WebElement uername;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
//	private WebElement email;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
//	private WebElement senha;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]")
//	private WebElement reSenha;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]")
//	private WebElement primeiroNome;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]")
//	private WebElement sobreNome;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]")
//	private WebElement telefone;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
//	private WebElement estado;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
//	private WebElement cidade;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
//	private WebElement endereco;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
//	private WebElement cep;
//
//	@FindBy(id = "com.Advantage.aShopping:id/textViewCountriesTitle")
//	private WebElement continente;
//
//	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/select_dialog_listview']")
//	private WebElement continentes;
//
//	@FindBy(className = "android.widget.Button")
//	private WebElement btnRegistrar;

	@SuppressWarnings("rawtypes")
	public TelaFormularioPage enter() throws MalformedURLException {
		(new TouchAction(DriverFactory.inicializarDriver())).tap(PointOption.point(985, 1699)).perform();
		return this;
	}

	public void inserirUserName(String userName) {
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")));
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
				.click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
				.sendKeys(userName);
	}

	public void inserirEmail(String email) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
				.click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
				.sendKeys(email);

	}

	public void inserirSenha(String senha) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
				.click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
				.sendKeys(senha);

	}

	public void confirmarSenha(String confirmSenha) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]").sendKeys(confirmSenha);
	}

	public void inserirNome(String nome) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]").sendKeys(nome);

	}

	public void inserirSobrenome(String sobrenome) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]").sendKeys(sobrenome);
	
	}

	public void inserirTelefone(String telefone) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]").sendKeys(telefone);
		
	}

	public void inserirEstado(String estado) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]").sendKeys(estado);
		
	}

	public void inserirCidade(String cidade) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]").sendKeys(cidade);
	
	}

	public void inserirEndereco(String endereco) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]").sendKeys(endereco);
	
	}

	public void inserirCep(String CEP) {
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]").click();
		driver.findElementByXPath("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]").sendKeys(CEP);

	}

	public void selecionarPais(AndroidDriver<WebElement> driver, String pais) {

        wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.Advantage.aShopping:id/textViewCountries"))).click();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
                        + pais + "\").instance(0))")
                .click();
    }

	public void registrar() throws MalformedURLException {
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.Advantage.aShopping:id/buttonRegister"))).click();
	}
	
	public boolean verificarSeRegistrarEstaDisponivel() {
		new Actions(driver).moveToElement(driver.findElementById("com.Advantage.aShopping:id/buttonRegister")).perform();
		return driver.findElementById("com.Advantage.aShopping:id/buttonRegister").isEnabled();

	}

//	@SuppressWarnings("rawtypes")
//	public TelaFormularioPage scroll() {
//		try {
//			(new TouchAction(DriverFactory.criarDriver())).press(PointOption.point(508, 1130))
//					.moveTo(PointOption.point(525, 483)).release().perform();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//
//		return this;
//	}

}
