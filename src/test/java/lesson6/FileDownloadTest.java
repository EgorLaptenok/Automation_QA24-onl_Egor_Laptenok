package lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuApp.FileDownloadPage;
import pageObjects.herokuApp.steps.HomeSteps;

import static pageObjects.herokuApp.HomePageItem.FILE_DOWNLOAD;

public class FileDownloadTest extends BaseTest {
    HomeSteps homeSteps;
    FileDownloadPage fileDownloadPage;

    @BeforeTest
    public void precondition() {
        homeSteps = new HomeSteps();
        fileDownloadPage = new FileDownloadPage();
        homeSteps.navigateTo(FILE_DOWNLOAD);
    }

    @Description("File download test")
    @Step("Download spectrum-logo.png")
    @Link("https://the-internet.herokuapp.com/download")
    @Test(priority = 1)
    public void fileDownloadTest() {
        fileDownloadPage.verifyPage();
        fileDownloadPage.downloadFile("spectrum-logo.png");
    }

    @Description("Test failed")
    @Step("call screenshot")
    @Link("https://the-internet.herokuapp.com/download")
    @Test(priority = 1)
    public void secondFileDownloadTest() {
        fileDownloadPage.verifyPage();
        fileDownloadPage.verifyPageForFall();
    }
}
