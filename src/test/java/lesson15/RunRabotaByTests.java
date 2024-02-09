package lesson15;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue ={"cucumber/rabotaBy"},
        plugin = {
                "json:target/cucumber.json",
                "html:target/rabotaBy/cucumber-pretty.html"
        },
        tags = "@smoke"
)
public class RunRabotaByTests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
