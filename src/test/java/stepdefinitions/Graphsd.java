package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.driversetup;
import PageObjects.GraphPage;
import PageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class Graphsd extends Combase {

	WebDriver driver = driversetup.getDriver();
	String excelpath = ".\\src/test/resources/ExcelData/code.xlsx";
	String output="";
	String expmsg;
	String actmsg;
	String windowtitle;
	GraphPage graphpage = new GraphPage(driver);

	@Given("user able to click on dropdown for Graph")
	public void user_able_to_click_on_dropdown_for_Graph() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.dropDownclk();
		Thread.sleep(1000);   
	}

	@When("user select Graph option")
	public void user_select_Graph_option() throws InterruptedException {
		graphpage.HomepageDropdown();
		Thread.sleep(1000);
		LoggerLoad.info("select Graph menu from dropdown");	   
	}

	@When("user clicks on Graph option")
	public void user_clicks_on_Graph_option() throws InterruptedException {
		LoggerLoad.info("select Graph from dropdown options");
		graphpage.dropdownOption();		
		Thread.sleep(1000);   
	}

	@Given("User is on Graph Home page and clicks on graph topic")
	public void User_is_on_Graph_Home_page_and_clicks_on_graph_topic() {
		graphpage.graphHomepage();
	}


	@Then("user should be redirected to Graph Graph page")
	public void user_should_be_redirected_to_Graph_Graph_page() {
		String Title = graphpage.getGraphPageTitle();
		LoggerLoad.info("Title of current page: " + Title);
		assertEquals(Title, "Graph", "Title not matched");
	}

	@Given("User click on Try here button on Graph Graph page and navigate to tryEditor page")
	public void User_click_on_Try_here_button_on_Graph_Graph_page_and_navigate_to_tryEditor_page() {
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		graphpage.Tryhere();
	}

	@When("user enter valid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_valid_python_code_in_tryEditor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(int1).get("code"); // Column heading
		String output=testData.get(int1).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		graphpage.Textarea(code, output);	

	}

	@When("User click on run button")
	public void user_click_on_run_button() throws InterruptedException {
		graphpage.run();
		LoggerLoad.info("click graph run button");
		Thread.sleep(1000);
	}

	@Then("User should be presented with run output")
	public void user_should_be_presented_with_run_output() throws InterruptedException {
		actmsg=graphpage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}

	@When("user enter invalid python code in tryEditor from sheet {string} and {int}")
	public void user_enter_invalid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(int1).get("code"); // Column heading
		String output=testData.get(int1).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		graphpage.Textarea(code,output);

	}

	@Then("User should get alert message")
	public void alert_should_be_present() throws InterruptedException {

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
	
	@Given("User click on Graph Representations topic")
	public void User_click_on_Graph_Representations_topic() {
		graphpage.ClickgraphRepresentations();
	}
	
	@When("click Try here button and navigate to tryEditor page")
	public void click_Try_here_button_and_navigate_to_tryEditor_page() {
		graphpage.graphrepresentationsTryhere();
	}
	
	@When("user enter valid python code for graphrepresentations in tryEditor from sheet {string} and {int}")
	public void user_enter_valid_python_code_for_graphrepresentations_in_tryEditor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter valid python code for graphrepresentations");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(int1).get("code"); // Column heading
		String output=testData.get(int1).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		graphpage.Textarea(code, output);
	}
	
	@When("User click on run button for graphrepresentations")
	public void user_click_on_run_button_for_graphrepresentations() throws InterruptedException {
		graphpage.graphrepresentationsRunbutton();
		LoggerLoad.info("click graph run button");
		Thread.sleep(1000);
	}

	@Then("User should be presented with run output for graphrepresentations")
	public void user_should_be_presented_with_run_output_for_graphrepresentations() throws InterruptedException {
		actmsg=graphpage.output();
		System.out.println(actmsg);
		driver.navigate().back();
	}
	
	@When("user enter invalid python code for graphrepresentations in tryEditor from sheet {string} and {int}")
	public void user_enter_invalid_python_code_for_graphrepresentations_in_try_editor_from_sheet_and(String string, Integer int1) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		LoggerLoad.info("User enter invalid python code");
		List<Map<String, String>> testData=reader.getData(excelpath,"Sheet1");
		String code=testData.get(int1).get("code"); // Column heading
		String output=testData.get(int1).get("output"); // Column heading
		expmsg=output;
		System.out.println(code);
		System.out.println(output);
		graphpage.Textarea(code,output);

	}

	@Then("User should get alert message for graphrepresentations")
	public void alert_should_be_present_for_graphrepresenttions() throws InterruptedException {

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
	
	@When("user clicks on Practice Questions in graph representations page")
	public void user_clicks_on_Practice_Questions_in_graph_representations_page() {
		graphpage.ClickpracticeQuestions();
	}


}
