package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.Combase;

public class GraphPage extends Combase {
	
	WebDriver driver;
	
	@FindBy (xpath="//a[text()='Graph']") WebElement graphOption;
	@FindBy(xpath = "//a[@href='graph']") WebElement graphGraphpage;
	//@FindBy(xpath = "//a[@class='btn btn-info']") WebElement tryhere;
	@FindBy(linkText="Try here>>>") WebElement tryhere;
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea") WebElement textarea;
	
	//@FindBy(xpath = "//button[contains(text(),'Run')]") WebElement runbutton;
	@FindBy(xpath="//button[text()='Run']") WebElement runbutton;
	//@FindBy(xpath = "//pre[@id='output']") WebElement output;
	@FindBy(id="output") WebElement  output;
	@FindBy(linkText="Practice Questions") WebElement PracticeQuestions;
	
	@FindBy(linkText = "Graph Representations") WebElement graphGraphRepresentations;
	
	
	public GraphPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	/*public void dropdownOption()
	{
		graphOption.click();
	}*/
	
	public void graphHomepage()
	{
		graphGraphpage.click();
	}
	
	
	public void Tryhere()
	{
		tryhere.click();
	}
	
	public void Textarea(String code, String output)
	{
		textarea.sendKeys(code);
	}
	
	public void run()
	{
		runbutton.click();
	}
	
	public String output()
	{
		return output.getText();	
	}
	
	public void navigateback()
	{
		driver.navigate().back();
	}
	
	public void ClickgraphRepresentations()
	{
		graphGraphRepresentations.click();
	}
	
	
	public void ClickpracticeQuestions()
	{
		PracticeQuestions.click();
	}
	
	
}
