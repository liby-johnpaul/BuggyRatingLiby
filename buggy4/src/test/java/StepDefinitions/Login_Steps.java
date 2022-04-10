package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ModelPage;
import pageObjects.OverallPage;
import pageObjects.RegistrationPage;






public class Login_Steps {
	@SuppressWarnings("deprecation")
	

	
	WebDriver driver;
	HomePage page;
	int voteCountBefore=0;
	String gusername = "";
	String gpassword = "";
	String fname="";
	
	
	@Before(order=1)
	public void Browsersetup(){
		
	
        String projectPath = System.getProperty("user.dir");
		
	    System.setProperty("webdriver.chrome.driver", projectPath +"/src/test/resources/Drivers/chromedriver");
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);	
	}
	
	@Before("@Register")
	public void RegisterUser() {
		page = new HomePage(driver);
		
		driver.navigate().to("https://buggy.justtestit.org/");
		 
		 RegistrationPage Rp = new RegistrationPage(driver);
		 
        page.clickRegisterButton();
        
        Faker faker = new Faker();

        String username1 = faker.internet().emailAddress();        
        
        String password1 = "Pass@word1";
        
        gpassword = password1;
        
        gusername = username1;

        Rp.CreateNewUser(gusername,gpassword );
        
        System.out.println(gusername + gpassword);
	    
	
		
	}

	
	@SuppressWarnings("deprecation")
	@Given("I am in Buggy Home page")
	public void i_am_in_buggy_home_page() {
		
		driver.navigate().to("https://buggy.justtestit.org");
	}

	@When("^I log in using (.*) and (.*)$")
	public void i_log_in_using_user_name_and_password(String userName,String password) {
		
	
		page = new HomePage(driver);
		
		page.validLogin(userName, password);
	      
	}
	
	@And("I log in as a Registered user")
	public void i_log_in_as_a_Registered_user() {
		
		page= new HomePage(driver);
		page.validLogin(gusername, gpassword);
		System.out.println(gusername + gpassword);
	}

	@Then("^I see the customized Hello message with (.*) displayed$")
	public void i_see_the_customized_hello_message_displayed(String firstName) {
		
		page = new HomePage(driver);
		
		assertTrue(driver.findElement(page.helloMessage).isDisplayed());
		
		assertTrue(driver.findElement(page.helloMessage).getText().equals("Hi, "+firstName));
		
	     
	}
	
	@Then("I see the Invalid Username and password message is displayed")
	public void i_see_the_invalid_username_and_password_message_is_displayed() {
	    
		page = new HomePage(driver);
	    
	    assertTrue(driver.findElement(page.invalidMessage).isDisplayed());
	}
	
	
	//Overall--------------------------------------------------
	

	
	@When("I click on Overall Ratings Tile")
	public void i_click_on_Overall_Ratings_Tile() {
	
	page = new HomePage(driver);
	
	//click Overall Tile in Homepage
	
	page.clickOverallRatingTile();
		
		
	}

	@And("I click on a model")
	public void i_click_on_a_model() {
		
		OverallPage op = new OverallPage(driver);
		
		//Clicks a Model from Overall page
		op.clickModel();
	    

	}

	@And("click on Vote button")
	
	public void click_on_vote_button() {
		
		ModelPage mp = new ModelPage(driver);
		
		String voteCountB4 = driver.findElement(mp.voteCount).getText();
		
		voteCountBefore = Integer.parseInt(voteCountB4);
		//Clicks on Vote
	    driver.findElement(mp.voteButton).click();
	}

	@Then("I get a thankyou message")
	public void i_get_a_thankyou_message() {
		
		ModelPage mp = new ModelPage(driver);
		
		
	    assertTrue(driver.findElement(mp.Thanku).isDisplayed());
	}
	
	@Then("I get a message that you have to be logged in")
	public void i_get_a_message_to_log_in() {
		ModelPage mp= new ModelPage(driver);
		assertTrue(driver.findElement(mp.needToLogin).isDisplayed());
	}


	@And("Number of votes has increased by one")
	public void number_of_votes_has_increased_by_one() {
		
		
		page = new HomePage(driver);
		
		ModelPage mp = new ModelPage(driver);
		
	    String voteCountAfter = driver.findElement(mp.voteCount).getText();
	    
	    int voteCountAftr = Integer.parseInt(voteCountAfter);
	    
	    System.out.println(voteCountBefore + "voteCountBefore");
	    System.out.println(voteCountAfter + "voteCountAfter");
	    
	    assertTrue(voteCountAftr==voteCountBefore+1);
	}
	
	//Registration Step Definitions-----------------------------------------------------------
	
	@And("that I register on the site using:")
	public void that_i_register_on_the_site_using(DataTable dataTable) throws InterruptedException {
		
		 page = new HomePage(driver);
		 
		 RegistrationPage Rp = new RegistrationPage(driver);
		 
         page.clickRegisterButton();
         
         Faker faker = new Faker();

         String username1 = faker.internet().emailAddress();
         
         //Below method to extract data from dataTable
         List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
         
         String password1 = dataList.get(0).get("Password");
         
         gpassword = password1;
         
         gusername = username1;
         
         System.out.println(username1);

         Rp.CreateNewUser(username1, password1);
	    
	}

	@Then("verify registration is a success")
	public void verify_registration_is_a_success() {
		
		RegistrationPage Rp = new RegistrationPage(driver);

        assertTrue(driver.findElement(Rp.RegistrationSuccessMessage).isDisplayed());
	    
	}

	@Then("use created credentials to log in successfully")
	public void use_created_credentials_to_log_in_successfully() {
		page = new HomePage(driver);
		
		driver.navigate().to("https://buggy.justtestit.org/");
		
		page.validLogin(gusername, gpassword);
		
	    
	}

	
	
	@After
     public void closeBrowser() {
		System.out.println("after hook");
		
		driver.close();
		
		driver.quit();
	   
	}

	
}
