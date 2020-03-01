package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactPage extends BasePage {
	
	WebDriver driver;

	public ContactPage(WebDriver driver)
	{
		this.driver=driver;	
	}
	
	
	@FindBy(how=How.ID, using="account")
	WebElement FullName;
	
	@FindBy(how=How.ID, using="company")
	WebElement CompanyName;

	@FindBy(how=How.ID, using="email")
	WebElement Email;

	@FindBy(how=How.ID, using="phone")
	WebElement Phone;

	@FindBy(how=How.ID, using="address")
	WebElement Address;

	@FindBy(how=How.ID, using="city")
	WebElement City;

	@FindBy(how=How.ID, using="zip")
	WebElement Zip;

	@FindBy(how=How.ID, using="state")
	WebElement State;

	@FindBy(how=How.ID, using="submit")
	WebElement Submit;
	
	
	public void FillUpContactForm()
	{
		FullName.sendKeys("John Smith");
		CompanyName.sendKeys("Nokia");
		Email.sendKeys("Jsmith@gmail.com");
		Phone.sendKeys("3474307205");
		Address.sendKeys("2741E Beltline Rd");
		City.sendKeys("Dallas");
		Zip.sendKeys("19468");
		State.sendKeys("Texas");
		Submit.click();		
		
	}

	
	



}
