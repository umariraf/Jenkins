package tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ListAccountPage;
import pages.LoginClass;
import pages.NewAccountPage;
import util.BrowserFactory;
import util.ExcelReader;

public class NewAccountTest {
	
	Random rnd=new Random();
	
	
	ExcelReader reader = new ExcelReader("./data/2Fall2019.xlsx");
	

	String email=reader.getCellData("Sheet1", "User", 2);
	String password=reader.getCellData("Sheet1", "Password", 2);
	String title=reader.getCellData("Sheet1", "Atitle", 2);
	String description=reader.getCellData("Sheet1", "Description", 2);
	String balance=reader.getCellData("Sheet1", "Balance", 2);		
		
	@Test
	public void NewAccount() throws InterruptedException
	{
		
	WebDriver driver=  BrowserFactory.startBrowser();

	LoginClass logintowebsite=PageFactory.initElements(driver, LoginClass.class);

	logintowebsite.login(email,password);
	
	DashboardPage dash=PageFactory.initElements(driver, DashboardPage.class);
	
	Thread.sleep(3000);
	
	dash.GotoNewAccount();	

	
		
	String expectedTitle=title;	
	
	
	NewAccountPage account=PageFactory.initElements(driver, NewAccountPage.class);
	
	Thread.sleep(5000);
	
	account.FillupNewAccountForm(title, description, balance);
	
	ListAccountPage list=PageFactory.initElements(driver, ListAccountPage.class);
	
	Thread.sleep(5000);
	
	ListAccountPage listAccountPage = PageFactory.initElements(driver, ListAccountPage.class);
	
	Thread.sleep(5000);

	List<String> columnData = listAccountPage.getColumnDataFor("Account");
	
	Thread.sleep(5000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	
	Thread.sleep(5000);

	Assert.assertTrue(isDataPresent(expectedTitle,columnData ), "New Account did not post!!!!");
	
	driver.close();
	
	driver.quit();
	


	}

	private boolean isDataPresent(String expectedTitle, List<String> columnData) {
		for(String cellData:columnData ) {
			if(cellData.equalsIgnoreCase(expectedTitle)) {
				System.out.println("Displayed Data: " + cellData);
				return true;
			}
		}
		return false;
	}
	

}
