package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountPage {
	
WebDriver driver;
	
	public NewAccountPage(WebDriver driver)
	{
	
		this.driver=driver;	
	}
	
	@FindBy(how=How.ID, using="account")
	WebElement AccountTitle;
	
	@FindBy(how=How.ID, using="description")
	WebElement Description;
	
	@FindBy(how=How.ID, using="balance")
	WebElement Balance;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn btn-primary']")
	WebElement SubmitButton;	
	
	
	
	public void FillupNewAccountForm(String title, String description, String balance)
	{
	
		AccountTitle.sendKeys(title);
		Description.sendKeys(description);
		Balance.sendKeys(balance);
		SubmitButton.click();		
	}
	
	
	

}
