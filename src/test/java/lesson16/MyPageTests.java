package lesson16;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.myPage.HomePage;

public class MyPageTests {
    HomePage homePage;

    @BeforeTest
    public void setUp() {
        homePage = new HomePage();
        homePage.openURI();
    }

    @Test(priority = 1)
    public void tableTest() {
        homePage.firstColumnCollection();
    }

    @Test(priority = 2)
    public void inputTest() {
        homePage.inputIntoFields("Volga", "Leta");
    }

    @Test(priority = 3)
    public void checkboxTest() {
        homePage.clickOnTheCheckbox();
    }

    @Test(priority = 4)
    public void selectTest() {
        homePage.clickOnTheSelect("Brest");
    }

    @Test(priority = 5)
    public void imgTest() {
        homePage.isImgExists();
    }

    @Test(priority = 6)
    public void pTest() {
        homePage.correctText("This is some text in a paragraph.");
    }

    @Test(priority = 7)
    public void aTest() {
        homePage.clickToLink();
    }

    @AfterTest
    public void tearDown() {
        homePage.quit();
    }
}
