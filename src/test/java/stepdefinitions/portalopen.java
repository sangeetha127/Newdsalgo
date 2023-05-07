package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.*;
import utilities.*;
import PageObjects.portalopenpage;
import DriverFactory.*;

public class portalopen extends Combase {
	
	//private portalopenpage PortalPage = new  portalopenpage(driversetup.getDriver());
	WebDriver driver =driversetup.getDriver();
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws InterruptedException {
		
		portalPage = new portalopenpage(driversetup.getDriver());
		 LoggerLoad.info("launch browser");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Thread.sleep(2000);
	}

	@Given("User opens dsalgo portal app url")
	public void user_opens_dsalgo_portal_app_url() {
		driversetup.openPage("https://dsportalapp.herokuapp.com");
		//driver.switchTo().window(driver.getWindowHandle());	
		LoggerLoad.info("portal opened");
	}

	@When("User click on Get Started button")
	public void user_click_on_get_started_button() throws InterruptedException {
		portalPage.clickgetstartedbtn();
		LoggerLoad.info("Getstarted btn click");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Then("User is navigated to Home page")
	public void user_is_navigated_to_home_page() {
		String HomepgTitle = driversetup.getdriverTitle();
		String ExpTitle = portalPage.gethomepagetitle();
		LoggerLoad.info(driversetup.getdriverTitle());
		Assert.assertEquals(HomepgTitle,ExpTitle);
		LoggerLoad.info("User navigated to home page");
	}
}
