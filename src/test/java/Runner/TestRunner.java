package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\YOGESH\\workspace1\\cucum\\src\\test\\resources\\Requirement\\HomePage.feature", glue = "Cucumber_Test")
public class TestRunner {

}

