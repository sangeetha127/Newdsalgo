package stepdefinitions;
import org.openqa.selenium.WebDriver;

import DriverFactory.driversetup;
import PageObjects.DataStucturesIntr;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.LoggerLoad;

public class DataStructureSteps extends Combase{
	WebDriver driver = driversetup.getDriver();
	DataStucturesIntr datastrpage =new DataStucturesIntr(driver);
	

	@Given("User click on Get started button in data Structures module")
	public void user_click_on_get_started_button_in_data_structures_module() {
		LoggerLoad.info("Datastructures-Introduction");
		datastrpage.getstarted();
	}

	@When("User click on Time Complexity button")
	public void user_click_on_time_complexity_button() {
		LoggerLoad.info("Datastructures-Introduction - Timecomplexity");
		datastrpage.timecomplexity();
	}

	@Given("User click on practice questons")
	public void user_click_on_practice_questons() {
		LoggerLoad.info("Datastructures-Introduction - Practice Questions");
		datastrpage.practicequestions();
	}

	@Given("Navigate back to data stuctures introduction page")
	public void navigate_back_to_data_stuctures_introduction_page() {
	   driversetup.NavBack();
	   //driversetup.openPage("https://dsportalapp.herokuapp.com/home");
	}
}
