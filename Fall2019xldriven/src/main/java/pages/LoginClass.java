package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginClass extends BasePage {
	
WebDriver driver;

public LoginClass(WebDriver driver)
{
	this.driver=driver;	
}


@FindBy(how=How.ID, using="username")
WebElement UserName;

@FindBy(how=How.ID, using="password")
WebElement Password;

@FindBy(how=How.NAME,using="login")
WebElement SigninButton;


public void login(String email, String password)
{
UserName.sendKeys(email);	
Password.sendKeys(password);
SigninButton.click();
}

public String getPageTitle()
{
	
return driver.getTitle();

}



	
	

}
