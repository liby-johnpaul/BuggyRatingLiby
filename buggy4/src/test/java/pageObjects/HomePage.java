package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Login page elements ---------------------------------------

	By userName=By.name("login");
	By passWord=By.name("password");
	By loginButton=By.xpath("//button[contains(text(),'Login')]");
	public By OverallTile=By.cssSelector("a[href*='overall']");
	public By helloMessage=By.cssSelector("span.nav-link");
	public By RegisterButton=By.linkText("Register");
	public By invalidMessage=By.xpath("//span[contains(text(),'Invalid username/password')]");
	
	public void validLogin(String UserName, String PassWord) {
		
		
		  driver.findElement(userName).sendKeys(UserName);
		  driver.findElement(passWord).sendKeys(PassWord);
		  driver.findElement(loginButton).click();
		

	}
	
	public OverallPage clickOverallRatingTile() {
		driver.findElement(OverallTile).click();
		OverallPage Op= new OverallPage(driver);
		return Op;
	}
	
	public RegistrationPage clickRegisterButton() {
		
		driver.findElement(RegisterButton).click();
		RegistrationPage Rp=new RegistrationPage(driver);
		return Rp;
		
	}
	
	
	
	
}
