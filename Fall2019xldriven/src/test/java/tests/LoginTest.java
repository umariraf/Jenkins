package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.LoginClass;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

ExcelReader reader = new ExcelReader("./data/2Fall2019.xlsx");
	
	
String email=reader.getCellData("Sheet1", "User", 2);
String password=reader.getCellData("Sheet1", "Password", 2);	
	
	
@Test
public void TecfiosLogin()
{
	
WebDriver driver=  BrowserFactory.startBrowser();

LoginClass logintowebsite=PageFactory.initElements(driver, LoginClass.class);

logintowebsite.login(email,password);

driver.close();

driver.quit();


}

	

}
