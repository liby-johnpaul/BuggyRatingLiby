package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

public class RegistrationPage {
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;
	
	 
	  public By LoginField = By.id("username");
    public By FirstNameField = By.id("firstName");
    public By LastNameField = By.id("lastName");
    public By PasswordField = By.id("password");
    public By ConfirmPasswordField = By.id("confirmPassword");
    
    
    public By RegistrationSuccessMessage = By.xpath("//div[contains(text(),'Registration is successful')]");
    
    public void CreateNewUser(String user, String password)
    {
  	  Faker faker=new Faker();
        driver.findElement(LoginField).sendKeys(user);
        driver.findElement(FirstNameField).sendKeys(faker.name().firstName());
        driver.findElement(LastNameField).sendKeys(faker.name().lastName());
        driver.findElement(PasswordField).sendKeys(password);
        driver.findElement(ConfirmPasswordField).sendKeys(password+"\n");

      
    }

}


