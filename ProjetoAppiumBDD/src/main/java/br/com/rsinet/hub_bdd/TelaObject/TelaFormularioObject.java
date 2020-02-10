package br.com.rsinet.hub_bdd.TelaObject;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaFormularioObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	@SuppressWarnings("unchecked")
	public TelaFormularioObject(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}

	@FindBy(className = "android.widget.RelativeLayout")
	private List<WebElement> elementos;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")
	private WebElement txtUserName;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextEmail']/child::*[1]")
	private WebElement txtEmail;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPassword']/child::*[1]")
	private WebElement txtSenha;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextConfirmPassword']/child::*[1]")
	private WebElement txtConfirmarSenha;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextFirstName']/child::*[1]")
	private WebElement txtNome;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextLastName']/child::*[1]")
	private WebElement txtSobreNome;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextPhoneNumber']/child::*[1]")
	private WebElement txtTelefone;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextState']/child::*[1]")
	private WebElement txtEstado;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextCity']/child::*[1]")
	private WebElement txtCidade;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextStreet']/child::*[1]")
	private WebElement txtEndereco;

	@FindBy(xpath = "//*[@resource-id='com.Advantage.aShopping:id/AosEditTextZip']/child::*[1]")
	private WebElement txtCep;

	@FindBy(id = "com.Advantage.aShopping:id/textViewCountriesTitle")
	private WebElement cbxPais;

	@FindBy(className = "android.widget.Button")
	private WebElement btnRegistrar;

	@FindBy(id = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement btnVerificarSeRegitrarDisponivel;

//	@SuppressWarnings("rawtypes")
//	public TelaFormularioObject enter() throws MalformedURLException {
//		(new TouchAction(DriverFactory.inicializarDriver())).tap(PointOption.point(985, 1699)).perform();
//		return this;
//	}

	public void inserirUserName(String userName) {
		// wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("//*[@resource-id='com.Advantage.aShopping:id/AosEditTextUserName']/child::*[1]")));
		txtUserName.click();
		txtUserName.sendKeys(userName);

	}

	public void inserirEmail(String email) {
		txtEmail.click();
		txtEmail.sendKeys(email);
	}

	public void inserirSenha(String senha) {
		txtSenha.click();
		txtSenha.sendKeys(senha);

	}

	public void confirmarSenha(String confirmSenha) {
		txtConfirmarSenha.click();
		txtConfirmarSenha.sendKeys(confirmSenha);
	}

	public void inserirNome(String nome) {
		txtNome.click();
		txtNome.sendKeys(nome);

	}

	public void inserirSobrenome(String sobrenome) {
		txtSobreNome.click();
		txtSobreNome.sendKeys(sobrenome);

	}

	public void inserirTelefone(String telefone) {
		txtTelefone.click();
		txtTelefone.sendKeys(telefone);

	}

	public void inserirEstado(String estado) {
		txtEstado.click();
		txtEstado.sendKeys(estado);

	}

	public void inserirCidade(String cidade) {
		txtCidade.click();
		txtCidade.sendKeys(cidade);

	}

	public void inserirEndereco(String endereco) {
		txtEndereco.click();
		txtEndereco.sendKeys(endereco);

	}

	public void inserirCep(String CEP) {
		txtCep.click();
		txtCep.sendKeys(CEP);

	}

	public void selecionarPais(AndroidDriver<WebElement> driver, String pais) {

		wait.until(ExpectedConditions.visibilityOf(cbxPais)).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ pais + "\").instance(0))")
				.click();
	}

	public void registrar() throws MalformedURLException {
		wait.until(ExpectedConditions.visibilityOf(btnRegistrar)).click();
	}

	public boolean verificarSeRegistrarEstaDisponivel() {
		new Actions(driver).moveToElement(btnVerificarSeRegitrarDisponivel).perform();
		return btnVerificarSeRegitrarDisponivel.isEnabled();

	}

}
