package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driversetup;
import PageObjects.Arrays;
import PageObjects.HomePage;
import PageObjects.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import java.time.Duration;

public class arraySteps extends Combase{
	WebDriver driver =driversetup.getDriver();
	Arrays arrays = new Arrays(driver);

	String excelpath = ".\\src/test/resources/ExcelData/PythonExcel.xlsx";
	//String excelpath1=".\\ExcelData/invalid code.xlsx";
	String expectedcode;
	String actcode;
	String output;
	String result;

	@Given("User click on get started button on array module and navigate to array page")
	public void user_click_on_get_started_button_on_array_module_and_navigate_to_array_page() {
		/*driversetup.openPage("https://dsportalapp.herokuapp.com/login");
		loginpage= new Loginpage(driver);
		loginpage.enternamepasswrd("nitha", "nithasdet109");
		loginpage.loginbtnclk();
		String actUrl = driver.getCurrentUrl();
		String expUrl = "https://dsportalapp.herokuapp.com/home";
		Assert.assertEquals(expUrl, actUrl);*/
		LoggerLoad.info("Arrays");
		homepage = new HomePage(driver);
		homepage.dropDownclk();
		homepage.arrays();
		//arrays.ArrayGetStarted();
	}

	@When("User click on Arrays in Python Topic and navigate to arrays in python page")
	public void user_click_on_arrays_in_python_topic_and_navigate_to_arrays_in_python_page() {
		LoggerLoad.info("Arrays - ArraysInPython");
		arrays.ArraysInPython();
	}

	@Given("User click on Try here button on Arrays in Python page and navigate to try edidor page")
	public void user_click_on_try_here_button_on_arrays_in_python_page() {
		LoggerLoad.info("Arrays - Tryhere");
		//JavascriptExecutor js =  (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,1000)");
		arrays.TryHere();
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {

		ExcelReader reader = new ExcelReader();

		List<Map<String,String>>testdata = reader.getData(excelpath, "sheet1");
		String pycode = testdata.get(int1).get("code");
		String output= testdata.get(int1).get("result");
		LoggerLoad.info("Arrays - valid python code");
		arrays.Txtarea(pycode,output);
	}


	@When("User click on run button")
	public void user_click_on_run_button() throws InterruptedException {
		LoggerLoad.info("Arrays  - Run button");
		arrays.Runbutton();
	}

	@Then("User should be presented with run result")
	public void user_should_be_presented_with_run_result() throws InterruptedException {
		String result=( arrays.outPut());
		LoggerLoad.info("Arrays - Valid output=" +result ); 
		arrays.textclear();
	}
	@When("The user enter invalid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_invalid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String,String>>testdata = reader.getData(excelpath, "sheet1");
		String pycode = testdata.get(int1).get("code");
		String output= testdata.get(int1).get("result");
		LoggerLoad.info("Arrays - invalid python code");
		
		arrays.Txtarea(pycode,output);
	}
	@Then("User should get alert message")
	public void alert_should_be_present() {

		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			{
			System.out.println("alert not exist");
			LoggerLoad.info("Arrays - alert not exist"); }
		else
		{ System.out.println("Alert exists");
		LoggerLoad.info("Arrays - Alert exists"); }

		alert.accept();
		driversetup.NavBack();
	}
	@Given("User click on Arrays Using List topic")
	public void user_click_on_arrays_using_list_topic() {
		LoggerLoad.info("Arrays - Arrays Using List");
		arrays.arraysList();
	}
	@Given("click Try here button and navigate to try edidor page")
	public void click_try_here_button_and_navigate_to_try_edidor_page() {
		LoggerLoad.info("Arrays - try here"); 
		arrays.TryHere();
	}
	@Given("User click on basic Operations in Lists")
	public void user_click_on_basic_operations_in_lists() {
		LoggerLoad.info("Arrays - basic_operations");
		arrays.BasicOpInList();
	}

	@Given("User click on Applications of Array")
	public void user_click_on_applications_of_array() {
		LoggerLoad.info("Arrays - applications_of_array");
		arrays.ApplOfArray();
	}

	@Given("User click on Practies Questions")
	public void user_click_on_practies_questions() {
		LoggerLoad.info("Arrays - Practice Questions");
		arrays.PraQues();
	}

	@When("User click on Question1 its navigate to tryeditor page")
	public void user_click_on_question1_its_navigate_to_tryeditor_page() {
		LoggerLoad.info("Arrays - Practice Questions1");
		arrays.que1();
	}

	@When("User clear the tryeditor textbox")
	public void user_clear_the_tryeditor_textbox() throws InterruptedException {
		arrays.txteditorclr();
		}
	@When("User click on Question2 its navigate to tryeditor page")
	public void user_click_on_question2_its_navigate_to_tryeditor_page() {
		LoggerLoad.info("Arrays - Practice Questions2");
		arrays.que2();
	}

	@When("User click on Question3 its navigate to tryeditor page")
	public void user_click_on_question3_its_navigate_to_tryeditor_page() {
		LoggerLoad.info("Arrays - Practice Questions3");
		arrays.que3();
	}

	@When("User click on Question4 its navigate to tryeditor page")
	public void user_click_on_question4_its_navigate_to_tryeditor_page() {
		LoggerLoad.info("Arrays - Practice Questions4");
		arrays.que4();
	}
}
