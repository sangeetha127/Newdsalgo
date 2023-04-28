package stepdefinitions;
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

import DriverFactory.*;
import PageObjects.*;
import io.cucumber.java.en.*;
import utilities.*;

public class registrationsd extends Combase {
	String excelpath =".\\src/test/resources/ExcelData/ds-algoregistration.xlsx";
	int rowval=0;
	//String excelpath =".\\src/test/resources/ExcelData/dummysheet.xlsx";

	String expmsg="";
	WebDriver driver =driversetup.getDriver();
	
	@Given("user click registration link")
	public void user_click_registration_link() throws InterruptedException  {
		//driver.switchTo().window(driver.getWindowHandle());
		registerPage = new registrationpage(driver);
		loginpage = new Loginpage(driver);
		registerPage.registrationlink();
		Thread.sleep(2000);
	}

	@When("user enter username,password,confirm password from given {string} and {int}")
	public void user_enter_username_password_confirm_password_from_given_and(String string, Integer int1) throws IOException, InvalidFormatException, InterruptedException {	  

		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter registration credentials");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		LoggerLoad.info("excel list size : " +testData.size());
		String User_name=testData.get(int1).get("username"); // Column heading
		String Pass_word=testData.get(int1).get("password"); // Column heading
		String Pass_wordcnf = testData.get(int1).get("passwordconfirm");
		expmsg=testData.get(int1).get("expectedmsg");
		System.out.println(User_name);
		System.out.println(Pass_word);
		System.out.println(Pass_wordcnf);
		System.out.println(expmsg);
		registerPage.readusernameandpassword(User_name, Pass_word,Pass_wordcnf);
		rowval=int1;
		LoggerLoad.info("Registration credentials entered");
		Thread.sleep(2000);
	}

	@Then("user click register button with expected message")
	public void user_click_register_button_with_expected_message() throws InterruptedException {
		registerPage.regbtnclk();
		
		String actmsg="";

		/*Scenario scenario;
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driversetup.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); 
		}   */

		//driversetup.tearDown();
		if (rowval<=2) {
			WebElement hidtext=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='username']"))));
			LoggerLoad.info(hidtext.getAttribute("validationMessage"));
			actmsg=hidtext.getAttribute("validationMessage");
			assertEquals(actmsg,expmsg);
		}
		else if ((rowval>2) && (rowval<10)){
			actmsg=registerPage.alertdismsg();
			assertEquals(actmsg,expmsg);
		}
		else if(rowval==10) {
			actmsg=loginpage.loginalertdismsg();
			//assertEquals(actmsg,expmsg);
			Thread.sleep(1000);
			System.out.println(loginpage.loginalertdismsg());
			
			
			//loginpage.signinlinkclk();
		}
		/*.info("Expected Message - Excel Sheet :  " +expmsg);
		LoggerLoad.info("Actual Message :  "+actmsg);
		Thread.sleep(2000);*/
	}
	@Given("user navigate to login page")
	public void user_navigate_to_login_page() throws InterruptedException {
		driver.getTitle();
		Thread.sleep(1000);
		LoggerLoad.info(driver.getTitle());
		loginpage = new Loginpage(driver);
	}

	@Then("click sign out")
	public void click_sign_out() {
		loginpage.signoutclk();
	}
}
