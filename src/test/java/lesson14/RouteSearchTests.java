package lesson14;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HomePage;
import pageObjects.rw.SearchPage;

import static com.codeborne.selenide.Selenide.back;


public class RouteSearchTests extends BaseTestSelenide {
    @Test(priority = 1)
    public void testSuccessfulRouteSearch() {
        get(HomePage.class)
                .enterFrom("Минск")
                .enterTo("Гродно")
                .clickSearch();
        get(SearchPage.class).map("Гродно");
        back();
    }

    @Test(priority = 2)
    public void DepartureTimeFilterTests() {
        get(HomePage.class)
                .enterFrom("Минск")
                .enterTo("Брест")
                .enterDate("12.02.2024")
                .clickSearch();
        get(SearchPage.class).map("Брест");
        back();
    }

    @Test(priority = 3)
    public void testInvalidRouteSearch() {
        get(HomePage.class)
                .enterFrom("Минск")
                .enterTo("Париж")
                .clickSearch();
        get(SearchPage.class).error();
        back();
    }
}
