package stepdefinitions;

import DriverFactory.driversetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObjects.*;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.*;

public class Loginsteps extends Combase {
	
	String excelpath =".\\src/test/resources/ExcelData/ds-algologin.xlsx";
	String message="";
	String actmsg="";
	int rowval=0;
	WebDriver driver;
	//WebDriver driver =driversetup.getDriver();
	
	@Given("The user is on signin page")
	public void the_user_is_on_signin_page() {
		driver =driversetup.getDriver();
		LoggerLoad.info("Login page entered");
		driversetup.openPage("https://dsportalapp.herokuapp.com/login");
		//loginpage = new Loginpage(driver);
		//loginpage.signoutclk();
		//loginpage.signinlinkclk();
	}

	@When("The user enter sheet {string} and {int}")
	public void the_user_enter_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException, InterruptedException {
		loginpage = new Loginpage(driver);
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testdata = reader.getData(excelpath,string);
		String username = testdata.get(int1).get("username");
		String password = testdata.get(int1).get("password");
		message = testdata.get(int1).get("expectedmessage");
		rowval=int1;
		LoggerLoad.info("User name and password enter");

		//if (username != null || password != null) {
			loginpage.enternamepasswrd(username, password);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//}
	}

	@Then("click login button")
	public void click_login_button() throws InterruptedException {
		LoggerLoad.info("User clicks on login button");
		loginpage.loginbtnclk();
		if (rowval==0) {
			WebElement hidtext=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='password']"))));
			LoggerLoad.info(hidtext.getAttribute("validationMessage"));
			actmsg=hidtext.getAttribute("validationMessage");
			assertEquals(actmsg,message);		
		}
		else if (rowval==1) {
			WebElement hidtext=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
			LoggerLoad.info(hidtext.getAttribute("validationMessage"));
			actmsg=hidtext.getAttribute("validationMessage");
			assertEquals(actmsg,message);
		}
		else
		{
			actmsg = loginpage.loginalertdismsg();
		}
		LoggerLoad.info("Expected Message - Excel Sheet :  " + message);
		LoggerLoad.info("Actual Message :  " + actmsg);
		assertEquals(actmsg, message);
	}
}
