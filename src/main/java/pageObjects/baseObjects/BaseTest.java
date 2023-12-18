package pageObjects.baseObjects;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static driver.DriverCreation.createDriver;
import static driver.DriverTypes.*;
import static driver.DriverCreation.quitDriver;

public abstract class BaseTest {
    @BeforeTest
    public void setUp() {
        createDriver(CHROME);
    }

    @AfterTest
    public void tearDown() {
        quitDriver();
    }
}
