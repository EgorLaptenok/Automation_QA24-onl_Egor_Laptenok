package lesson5;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuApp.DynamicControlsPage;
import pageObjects.herokuApp.FramesPage;
import pageObjects.herokuApp.HomePage;

import static pageObjects.herokuApp.HomePageItem.*;

public class HerokuTests extends BaseTest {
    HomePage homePage;
    DynamicControlsPage dynamicControlsPage;
    FramesPage framesPage;

    @BeforeTest
    public void precondition() {
        homePage = new HomePage();
        dynamicControlsPage = new DynamicControlsPage();
        framesPage = new FramesPage();
        homePage.open("https://the-internet.herokuapp.com/");
    }

    @Test(priority = 1)
    public void homePageTest() {
        homePage.verifyPage();
    }

    @Test(priority = 2)
    public void DynamicControlsTest() {
        homePage.clickOnItem(DYNAMIC_CONTROLS);
        dynamicControlsPage.verifyPage();
        dynamicControlsPage.clickRemoveButton();
        dynamicControlsPage.successfulGoneText();
        dynamicControlsPage.successfulCheckbox();
        dynamicControlsPage.inputIsNotEnable();
        dynamicControlsPage.clickEnableButton();
        dynamicControlsPage.successfulEnableText();
        dynamicControlsPage.inputIsEnable();
    }
    @Test(priority = 3)
    public void framesTest(){
        homePage.open("https://the-internet.herokuapp.com/");
        homePage.clickOnItem(FRAMES);
        framesPage.verifyPage();
        homePage.clickOnItem(IFRAME);
        framesPage.switchToIn();
        framesPage.findElementIsParagraph();
        framesPage.switchToOut();
    }
}
