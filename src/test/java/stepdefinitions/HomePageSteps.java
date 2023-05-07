package stepdefinitions;

import PageObjects.HomePage;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import DriverFactory.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.*;


public class HomePageSteps extends Combase {
	WebDriver driver =driversetup.getDriver();
	
	@Given("User click on Data Structures dropdown")
	public void user_click_on_data_structures_dropdown() throws InterruptedException {
		LoggerLoad.info("Home Page dropdown click");
		homepage = new HomePage(driversetup.getDriver());
		homepage.dropDownclk();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@When("User click on arrays from the dropdown")
	public void user_click_on_arrays_from_the_dropdown() throws InterruptedException {
		homepage.arrays();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Then("It  shows error message {string}")
	public void it_shows_error_message(String string) {
		LoggerLoad.error("shows user not logged in");
		String actmsg=homepage.alert();
	   assertEquals(actmsg,string);
	}

	@When("User click on one of the module from home page")
	public void user_click_on_one_of_the_module_from_home_page() throws InterruptedException {
	   driversetup.NavBack();
	   LoggerLoad.info("Get started button click");
	   homepage = new HomePage(driversetup.getDriver());
	   homepage.modulegtstarted();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@Then("It is showing error message You are not logged in")
	public void it_is_showing_error_message_you_are_not_logged_in() {
		LoggerLoad.error("shows user not logged in");
		String actmsg1=homepage.alert();
		 assertEquals(actmsg1,"You are not logged in");
	}


}