package ui;

import Objects.Account;
import Objects.Appointment;
import Pages.*;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestAppointment {
    Account account;
    Appointment appointment;
    WebDriver driver;

    BasePage basePage;
    HomePage homePage;
    LoginPage loginPage;
    MakeAppointmentPage makeAppointmentPage;
    AppointmentConfirmationPage appointmentConfirmationPage;

    @BeforeClass
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browserName) {
        account = new Account();
        account.setUsername("John Doe");
        account.setPassword("ThisIsNotAPassword");

        appointment = new Appointment();

        basePage = new BasePage(driver);
        driver = basePage.setupDriver(browserName);

        homePage = new HomePage(driver);
        homePage.navigate(Constants.AUT_URL);
        homePage.clickMakeAppointment();

        loginPage = new LoginPage(driver);

        loginPage.login(account);

        makeAppointmentPage = new MakeAppointmentPage(driver);
        appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
    }

    @AfterClass
    public void tearDown() {
        basePage.cleanUp();
    }

    @Test
    public void testMakeAppointment() {
        makeAppointmentPage.makeAppointment(appointment);
        appointmentConfirmationPage.compareAppointment(appointment, appointmentConfirmationPage.getAppointmentInfo());
    }
}
