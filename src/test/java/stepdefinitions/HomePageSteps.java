package stepdefinitions;

import PageObjects.HomePage;
import DriverFactory.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.*;


public class HomePageSteps extends Combase {

	@Given("User click on Data Structures dropdown")
	public void user_click_on_data_structures_dropdown() throws InterruptedException {
		LoggerLoad.info("dropdown click");
		homepage = new HomePage(driversetup.getDriver());
		
		homepage.dropDownclk();
		
		Thread.sleep(2000);
	   
	}

	@When("User click on arrays from the dropdown")
	public void user_click_on_arrays_from_the_dropdown() {
		homepage.arrays();

	}

	@Then("It  shows error message {string}")
	public void it_shows_error_message(String string) {
	   homepage.alert();
	}

	@When("User click on one of the module from home page")
	public void user_click_on_one_of_the_module_from_home_page() {
	   //DriverFactory.NavBack();
	   homepage.modulegtstarted();
	}
	@Then("It is showing error message You are not logged in")
	public void it_is_showing_error_message_you_are_not_logged_in() {
	    homepage.alert();
	}


}