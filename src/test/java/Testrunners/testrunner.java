package Testrunners;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/Ds-algo.html",  //cucumber reports
				"json:target/Ds-algo.json",
				"rerun:target/rerun.txt", //mandatory for capture failures 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //reporting purpose-- html reports are created
		monochrome=true,  //console output color and eliminate junk characters
		//dryRun=false, // (=true)->compilation purpose mostly to chk stepdefinitions are implemented or not
		//tags = "@tag1 or @tag2 or @tag3 or @tag4 or @tag5", //tags from feature file
		tags = "@tag6", //tags from feature file
		features = {"src/test/resources/Features"}, //location of feature files, we can give this way-->".//features//"
		glue= {"stepdefinitions","Allhooks"}) //location of step definition files, gives granural level of info in test result

public class testrunner extends AbstractTestNGCucumberTests {
/*@Override
@DataProvider(parallel=true)
public Object[][] scenarios() {
	return super.scenarios();
}*/
//public class testrunner  {

}
