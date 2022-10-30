package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage {

	AndroidDriver<WebElement> Driver ;
	 
	 public LoginPage(AndroidDriver<WebElement> Driver) {
		 this.Driver=Driver;
	 }
	 
	By LogoMainScreen = By.xpath("//android.view.ViewGroup[@bounds='[238,531][843,1034]']");
	By SignIN = By.xpath("//android.widget.Button[@index='1']");
	By SignInTitle = By.xpath("(//android.widget.TextView[@index='0'])[2]");
	By EmailID = By.xpath("//android.widget.EditText[@index='2']");
	By Password = By.xpath("//android.widget.EditText[@index='5']");
	By SubmitButton = By.xpath("//android.widget.Button[@index='1']");
	By ErrorMessage_EnterValidEmailID = By.xpath("//android.widget.TextView[@index='3']");
	By ErrorMessage_EnterValidPassword = By.xpath("//android.widget.TextView[@index='7']");
	By ErrorMessage_WrongCredentials = By.xpath("(//android.widget.TextView[@index='1'])[2]");
	
	
	public void Wait(WebElement Web) {
		WebDriverWait WW = new WebDriverWait(Driver,25);
		WW.until(ExpectedConditions.visibilityOf(Web));
	}
	
	
	public void ValidateLogo() {
		WebElement Ele = Driver.findElement(LogoMainScreen);
		Wait(Ele);
		Assert.assertTrue(Ele.isDisplayed());
	}
	
	public void FillEmailID(String id) {
		WebElement ID = Driver.findElement(EmailID);
		Wait(ID);
		ID.sendKeys(id);	
		
		
	}
	
	public void FillPassword(String PasswordValue) {
		WebElement pass = Driver.findElement(Password);
		Wait(pass);
		pass.sendKeys(PasswordValue);	
		
	}
	
	public void Submit() {
		WebElement submit = Driver.findElement(SubmitButton);
		Wait(submit);
		submit.click();
	}
	
	public void ValidateError_WrongCredential(String Text) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(ErrorMessage_WrongCredentials);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , Text);
	}
	
	public void ValidateError_EnterValidEmail(String Text) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(ErrorMessage_EnterValidEmailID);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , Text);
	}
	
	
	public void ValidateError_EnterValidPassword(String Text) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(ErrorMessage_EnterValidPassword);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , Text);
	}
	
	public void ClickOnSignINButton() throws InterruptedException {
		Thread.sleep(3000);
		WebElement button = Driver.findElement(SignIN);
		Wait(button);
		button.click();	
	}
	
	public void ValidateSignINPageTitle(String Title) throws InterruptedException {
		Thread.sleep(3000);
		WebElement TitlePage = Driver.findElement(SignInTitle);
		Wait(TitlePage);
		String PageTitle = TitlePage.getText();
		System.out.println(PageTitle);
		Assert.assertEquals(PageTitle , Title);
	}
	
}

