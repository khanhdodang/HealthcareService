package ui;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    WebDriver driver;
    BasePage basePage;

    @BeforeClass
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName) {
        basePage = new BasePage(driver);
        driver = basePage.setupDriver(browserName);
    }

    @AfterClass
    public void tearDown() {
        basePage.cleanUp();
    }
}
