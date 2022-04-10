package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverallPage {
	
	public WebDriver driver;
	   
	   public OverallPage(WebDriver driver) {
			this.driver=driver;
			// TODO Auto-generated constructor stub
		}

	   public By Model=By.linkText("Zonda");
	    
	   public ModelPage clickModel() {
			driver.findElement(Model).click();
			ModelPage Mp= new ModelPage(driver);
			return Mp;
		}
		
	    
	    
	}
	   


