package lesson9;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuApp.DataTablesPage;
import pageObjects.herokuApp.steps.HomeSteps;

import static pageObjects.herokuApp.HomePageItem.DATA_TABLES;

public class HerokuDataTableTest extends BaseTest {
    HomeSteps homeSteps;
    int count = 1;
    DataTablesPage dataTablesPage;

    @BeforeTest
    public void precondition() {
        homeSteps = new HomeSteps();
        dataTablesPage = new DataTablesPage();
        homeSteps.navigateTo(DATA_TABLES);
    }

    @Test(priority = 1, invocationCount = 4)
    public void dataTablesTest() {
        dataTablesPage.verifyPage();
        dataTablesPage.nameConversion(count++);
    }
}
