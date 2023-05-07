package Allhooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import DriverFactory.driversetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.LoggerLoad;

public class Hooks {
	//private static driversetup Driverset;
	//private static WebDriver driver;
	
	@Before(order=0)
	    public static void setUp() {
		 //Driverset=new driversetup();
		LoggerLoad.info("before hook order 0");
		driversetup.setUpDriver();
		
	    }
	@Before(order=1)
	public static void setup2() {
		LoggerLoad.info("before hook order 1");
		driversetup.getDriver();
		}
		 
	 @After
	    public static void tearDown(Scenario scenario) {
		 LoggerLoad.info("enter after hook");
	        if(scenario.isFailed()) {
	            final byte[] screenshot = ((TakesScreenshot)driversetup.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", scenario.getName()); 
	            driversetup.tearDown();
	        }   
	        //driversetup.tearDown();
	    }
}
