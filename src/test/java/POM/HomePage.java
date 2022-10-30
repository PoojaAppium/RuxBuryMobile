package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	AndroidDriver<WebElement> Driver ;
	 
	 public HomePage(AndroidDriver<WebElement> Driver) {
		 this.Driver=Driver;
	 }
	 
	By HomePageTitle = By.xpath("//android.view.View[@index='3']");
	
	public void Wait(WebElement Web) {
		WebDriverWait WW = new WebDriverWait(Driver,25);
		WW.until(ExpectedConditions.visibilityOf(Web));
	}
	
	public void ValidatePageTitle(String Title) throws InterruptedException {
		Thread.sleep(3000);
		WebElement TitlePage = Driver.findElement(HomePageTitle);
		Wait(TitlePage);
		String PageTitle = TitlePage.getText();
		System.out.println(PageTitle);
		Assert.assertEquals(PageTitle , Title);
	}
}
