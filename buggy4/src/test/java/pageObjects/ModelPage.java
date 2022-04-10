package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModelPage {
	
public WebDriver driver;
	
	public ModelPage(WebDriver driver) {
		this.driver=driver;
	}


	public By Model=By.linkText("Zonda");
	   
	   public By voteCount=By.cssSelector("div:nth-child(1) > h4 > strong");
	   
	   public By voteButton=By.xpath("//button[contains(text(),'Vote!')]");
	   
	   public By Thanku=By.xpath("//p[@class='card-text']");
	   
	   public By needToLogin=By.xpath("//p[contains(text(),'You need to be logged in to vote.')]");

}


