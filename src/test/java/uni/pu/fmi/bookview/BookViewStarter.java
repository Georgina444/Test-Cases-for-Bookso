package uni.pu.fmi.bookview;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;


// This class sets up the Cucumber test environment and configures it to generate readable reports.
@RunWith(Cucumber.class)  //This annotation tells JUnit to run the test using the Cucumber class as the test runner. This integrates Cucumber with JUnit.
@CucumberOptions(monochrome = true, plugin ={"pretty", "html:target/report.html"} )
public class BookViewStarter {
}


// monochrome = trueThis makes the console output more readable by removing unnecessary characters.
// pretty: Prints the Gherkin source with additional colors and stack traces for errors.
// html:target/report.html: Generates an HTML report in the target directory.