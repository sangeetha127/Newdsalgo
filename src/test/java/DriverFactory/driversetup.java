package DriverFactory;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilities.LoggerLoad;

public class driversetup {
	private static WebDriver driver;
	static ResourceBundle rb; // for reading properties file
	static String br; //to store browser name

	private static WebDriver getchromeDriver() {

		rb=ResourceBundle.getBundle("Config");
		br=rb.getString("browser");
		
		if(br.equals("CHROME"))
		{
			LoggerLoad.info("enter getchromedriver");
			System.setProperty("webdriver.chrome.driver",".\\src/test/resources/drivers/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--incognito");

			driver=new ChromeDriver(options);
		}
		/*else if br.equals("FIREFOX"){
		//Firefox
		System.setProperty("webdriver.firefox.driver", "C:/Users/sange/OneDrive/Desktop/Drivers/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		}
		else if (br.equals("edge")) {
		//Edge
		System.setProperty("webdriver.msedge.driver", "C:/Users/sange/OneDrive/Desktop/Drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		}*/
		driver.manage().window().maximize();
		return getDriver();
	}

	public static void openPage(String url) {
		driver.get(url);
	}
	public static String getTitle() {
		return driver.getTitle();
	}
	public static void NavBack() {
		driver.navigate().back();
	}
	public static WebDriver getDriver() {
		LoggerLoad.info("enter getdriver");
		return driver;
	}
	
	public static void setUpDriver() {
		if (driver==null) {
			getchromeDriver();
		}
	}
	
	public static void tearDown() {
		if(driver!=null) {
			LoggerLoad.info("enter teardown");
			driver.close();
			driver.quit();
		}
		driver = null;
	}

}
