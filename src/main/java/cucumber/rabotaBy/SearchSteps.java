package cucumber.rabotaBy;

import io.cucumber.java.en.*;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rabotaBy.HomePage;
import pageObjects.rabotaBy.SearchPage;


public class SearchSteps extends BaseTestSelenide {
    @Given("site user opens")
    public void precondition(){
       get(HomePage.class);
    }
    @When("user enters \"QA Automation\" in the search field")
    public void textInput() {
        get(HomePage.class).searchInput("QA Automation");
    }

    @And("the user clicks the \"Find a job\" button")
    public void clickButton() {
        get(HomePage.class).clickButton();
    }

    @Then("the page title contains the text \"Работа QA automation в Минске\"")
    public void outputSearch() {
        get(SearchPage.class).outputSearch("Работа QA automation в Минске");
    }

    @And("the number of vacancies found is greater than or equal to expected {string}")
    public void comparisonOfResults(String countVacation) {
        get(SearchPage.class).outputVacancies(countVacation);
    }

}
