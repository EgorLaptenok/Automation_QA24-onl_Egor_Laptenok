package lesson14;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.FormOfProtection;
import pageObjects.rw.HomePage;

public class StationSearchTests extends BaseTestSelenide {
    @Test(priority = 1)
    public void testSuccessfulStationSearch() {
        get(HomePage.class)
                .switchToStation()
                .enterSearchStation("Минск-Пассажирский");
        get(FormOfProtection.class)
                .clickButton()
                .clickButtonBack();
    }

    @Test(priority = 2)
    public void DepartureTimeFilterTests() {
        get(HomePage.class)
                .switchToStation()
                .enterDate2("17.02.2024")
                .enterSearchStation("Минск-Пассажирский");
        get(FormOfProtection.class)
                .clickButton()
                .clickButtonBack();
    }

    @Test(priority = 3)
    public void testInvalidStationSearch() {
        get(HomePage.class)
                .switchToStation()
                .enterSearchStation("Мадрид");
        get(FormOfProtection.class)
                .clickButton()
                .clickButtonBack();
    }
}
