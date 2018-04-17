package facebook;


import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/facebook/login.feature",
        format = {"pretty", "html:target/cucumber"})

public class RunTest { }
