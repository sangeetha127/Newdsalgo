package stepdefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driversetup;
//import PageObjects.GraphPage;
//import PageObjects.HomePage;
import PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class Graphsd extends Combase {
	WebDriver driver = driversetup.getDriver();
	String excelpath = ".\\src/test/resources/ExcelData/PythonExcel.xlsx";
	String output="";
	String expmsg;
	String actmsg;
	String windowtitle;
	GraphPage graphpage = new GraphPage(driver);
	Arrays arrays =new Arrays(driver);
	
	@Given("user able to click on dropdown for Graph")
	public void user_able_to_click_on_dropdown_for_graph() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.dropDownclk();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("user select Graph option")
	public void user_select_graph_option() throws InterruptedException {
		//graphpage.dropdownOption();
		homepage.selectgraph();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoggerLoad.info("Enter Graph Page");
	}

	@When("user clicks on Graph topic")
	public void user_clicks_on_graph_topic() {
		graphpage.graphHomepage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoggerLoad.info("Enter Graph topic");
	}

	@Given("click Try here button and navigate to tryEditor page")
	public void click_try_here_button_and_navigate_to_try_editor_page() {
		//graphpage.Tryhere();
		arrays.TryHere();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@When("user enter valid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_valid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid code in Graph");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String pythoncode=testData.get(int1).get("code"); // Column heading
		output=testData.get(int1).get("result"); // Column heading

		expmsg=output;
		System.out.println(pythoncode);
		System.out.println(output);
	
		graphpage.Textarea(pythoncode,output);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//arrays.Runbutton();
	}

	@Then("User should be presented with run output")
	public void user_should_be_presented_with_run_output() {
		actmsg=graphpage.output();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().back();
	}

	@When("user enter invalid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_invalid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid code in Graph");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String pythoncode=testData.get(int1).get("code"); // Column heading
		output=testData.get(int1).get("result"); // Column heading

		expmsg=output;
		System.out.println(pythoncode);
		System.out.println(output);
		graphpage. Textarea(pythoncode,output);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Given("user select graph representations")
	public void user_select_graph_representations() {
		graphpage.ClickgraphRepresentations();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoggerLoad.info("graph representations");
	}

	@Given("user select practice questions from graph")
	public void user_select_practice_questions_from_graph() throws InterruptedException {
		LoggerLoad.info("select practice questions in graph");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		graphpage.ClickpracticeQuestions();		
	}

	@Given("user navigate back and sign out from project")
	public void user_navigate_back_and_sign_out_from_project() {
		//driversetup.NavBack();
		loginpage = new Loginpage(driver);
		loginpage.signoutclk();
		driversetup.tearDown();
		
	}

	
	
	
	
	
	
	
	
	/*@Given("user able to click on dropdown for Graph")
	public void user_able_to_click_on_dropdown_for_graph() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.dropDownclk();
		Thread.sleep(1000);	
	}

	@When("user select Graph option")
	public void user_select_graph_option() throws InterruptedException {
		graphpage.dropdownOption(); 
		Thread.sleep(1000);	
	}

	@When("user clicks on Graph topic")
	public void user_clicks_on_graph_topic() {
	    graphpage.graphHomepage();
	}

	@Given("click Try here button and navigate to tryEditor page")
	public void click_try_here_button_and_navigate_to_try_editor_page() {
		 graphpage.Tryhere();
	}

	@When("user enter valid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_valid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid code in Graph");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String pythoncode=testData.get(int1).get("code"); // Column heading
		output=testData.get(int1).get("result"); // Column heading

		expmsg=output;
		System.out.println(pythoncode);
		System.out.println(output);
	
		graphpage. Textarea(pythoncode,output);	
	}

	@When("Graph User click on run button")
	public void graph_user_click_on_run_button() throws InterruptedException {
		graphpage.run();
		LoggerLoad.info("click graph run button");
		Thread.sleep(1000);
	}

	@Then("User should be presented with run output")
	public void user_should_be_presented_with_run_output() {
		actmsg=graphpage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("user enter invalid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_invalid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid code in Graph");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String pythoncode=testData.get(int1).get("code"); // Column heading
		output=testData.get(int1).get("result"); // Column heading

		expmsg=output;
		System.out.println(pythoncode);
		System.out.println(output);
		graphpage. Textarea(pythoncode,output);
	}

	@Then("Graph User should get alert message")
	public void graph_user_should_get_alert_message() throws InterruptedException {
		LoggerLoad.info("run button click for invalid code");
		Alert alert =driver.switchTo().alert();
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		if(w.until(ExpectedConditions.alertIsPresent())==null)
			System.out.println("alert not exist");
		else
			System.out.println("Alert exists");
		
		alert.accept();
		driversetup.NavBack();
		Thread.sleep(3000);   
	}

	@Given("user select graph representations")
	public void user_select_graph_representations() {
		 graphpage.ClickgraphRepresentations();
	}

	@Given("user select practice questions from graph")
	public void user_select_practice_questions_from_graph() throws InterruptedException {
		LoggerLoad.info("select practice questions in graph");
		graphpage.ClickpracticeQuestions();		
		Thread.sleep(1000);
	}

	@Given("user navigate back and sign out from project")
	public void user_navigate_back_and_sign_out_from_project() {
		driversetup.NavBack();
		loginpage = new Loginpage(driver);
		loginpage.signoutclk();
	}*/
	
}

