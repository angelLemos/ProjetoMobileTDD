package br.com.rsinet.hub_bdd.TelaObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class TelaLoginObject {
	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public TelaLoginObject(WebDriver driver) {
		this.driver = (AndroidDriver<WebElement>) driver;
		wait = new WebDriverWait(this.driver, 20);
	}

//		@FindBy(id = "com.Advantage.aShopping:id/textViewSingUpToday")
//		private WebElement lnkclicarEmNovaConta;

		public void clicarNovaConta() {
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("com.Advantage.aShopping:id/textViewDontHaveAnAccount")));
			driver.findElementById("com.Advantage.aShopping:id/textViewDontHaveAnAccount").click();
		}
		
		public void clicarEmUserName(String userName) {
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText\r\n" + 
					"").click();
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText\r\n" + 
					"").sendKeys(userName);
		}
		
		public void clicarEmPassword(String password) {
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText\r\n" + 
					"").click();
			driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText\r\n" + 
					"").sendKeys(password);

		}
		
		public void clicarEmLogin() {
			driver.findElementByXPath("//android.widget.Button[starts-with(@text, 'LOGIN')]").click();
			
		}

	}
