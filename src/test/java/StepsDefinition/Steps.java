package StepsDefinition;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import POM.HomePage;
import POM.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	public AndroidDriver<WebElement> Driver;
	 LoginPage LP;
	 HomePage HP;
	
	@Given("Application Launch")
	public void application_Launch() throws InterruptedException {
		 LP = new LoginPage(Driver);
	     Thread.sleep(2000);
			try{		
				DesiredCapabilities DC = new DesiredCapabilities();
				DC.setCapability("PlatformVersion", "12");
				DC.setCapability("deviceName", "vivo X70 Pro");
				DC.setCapability("UDID", "1361177652000IA");
				DC.setCapability("platformName", "Android");
				DC.setCapability("appActivity", "com.ruxburymobile.MainActivity");
				DC.setCapability("appPackage", "com.ruxburymobile");
				DC.setCapability("automationName", "UiAutomator2");
				DC.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
				DC.setCapability("noSign", true);
				DC.setCapability("autoGrantPermissions",true);
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				Driver = new AndroidDriver<WebElement>(url,DC);
				Driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS); 
				System.out.println("System Started");
				//Thread.sleep(5000);
				}
				catch(Exception exe) {
					exe.printStackTrace();
				}	
			
			Thread.sleep(2000);
	}

	@When("Application Open")
	public void application_Open() {
		 System.out.println("Application Opens");
	}

	@Then("Validate SplashScreen Logo")
	public void validate_SplashScreen_Logo() {
	   LP = new LoginPage(Driver);
	   LP.ValidateLogo();
	}

	@When("Click on SignIN button")
	public void click_on_SignIN_button() throws InterruptedException {
		 LP = new LoginPage(Driver);
		   LP.ClickOnSignINButton();
	}

	@Then("Validate SignIN page Title <Sign in to Ruxbury>")
	public void validate_SignIN_page_Title_Sign_in_to_Ruxbury() throws InterruptedException {
		 LP = new LoginPage(Driver);
		   LP.ValidateSignINPageTitle("Sign in to Ruxbury");
	}

	@When("Fill Email ID {string}")
	public void fill_Email_ID(String string) {
		 LP = new LoginPage(Driver);
		   LP.FillEmailID(string);
	}

	@And("Fill password {string}")
	public void fill_password(String string) {
		LP = new LoginPage(Driver);
		   LP.FillPassword(string);
	}

	@And("Click on submit")
	public void click_on_submit() {
		LP = new LoginPage(Driver);
		   LP.Submit();
	}

	@Then("Validate Home Page UI")
	public void validate_Home_Page_UI() throws InterruptedException {
		 HP = new HomePage(Driver);
		   HP.ValidatePageTitle("Home");
	}

	@And("Quite Application")
	public void quite_Application() {
	   Driver.quit();
	}

	@Then("Validate Error <Invalid credentials>")
	public void validate_Error_Invalid_credentials() throws InterruptedException {
		LP = new LoginPage(Driver);
		   LP.ValidateError_WrongCredential("Invalid credentials");
	}

	@Then("Validate Error <Enter valid email id>")
	public void validate_Error_Enter_valid_email_id() throws InterruptedException {
		LP = new LoginPage(Driver);
		   LP.ValidateError_EnterValidEmail("Enter valid email id");
	}

	@Then("Validate Error <Enter valid password>")
	public void validate_Error_Enter_valid_password() throws InterruptedException {
		LP = new LoginPage(Driver);
		   LP.ValidateError_EnterValidPassword("Enter valid password");
	}

}
