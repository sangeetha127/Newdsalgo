package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import utilities.*;
import stepdefinitions.Combase;

public class Loginpage extends Combase{


	@FindBy(linkText="Sign in") WebElement signinlink;
	@FindBy(id="id_username") WebElement usernametxt;
	@FindBy(id="id_password") WebElement passwrdtxt;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	@FindBy(xpath="//div[@role='alert']") WebElement alertmsg;
	@FindBy(linkText="Sign out") WebElement signoutlnk;

	public Loginpage(WebDriver webdriver) {
		PageFactory.initElements(webdriver,this);
		 //webdriver.switchTo().window(webdriver.getWindowHandle());
	}
	
	public boolean enternamepasswrd(String givenusrname,String givenpasswrd)
	{
		usernametxt.sendKeys(givenusrname);
		passwrdtxt.sendKeys(givenpasswrd);
		Boolean isRequired=false;
		
		// To check empty fields , we need to check "required" field is on an attribute
		/*if (givenusrname.isBlank()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", usrnametxt);
			return isRequired;
		} else if (givenpasswrd.isBlank()) {
			JavascriptExecutor js_password = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_password.executeScript("return arguments[0].required;",passwrdtxt);
			return isRequired;
		}*/
		return isRequired;
	}
	
	public void signinlinkclk() {
		signinlink.click();
	}

	public void loginbtnclk() {
		loginbtn.click();
	}
	
	public String loginalertdismsg()
	{
		return alertmsg.getText();
	}
	
	public void signoutclk() {
		signoutlnk.click();
	}

}
