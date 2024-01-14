package pageObjects.herokuApp.steps;

import pageObjects.herokuApp.HomePage;
import pageObjects.herokuApp.HomePageItem;

public class HomeSteps extends HomePage {
    public void navigateTo(HomePageItem item){
        open();
        clickOnItem(item);
    }
}
