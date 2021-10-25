package ui;

import Objects.Account;
import Objects.Appointment;
import Pages.AppointmentConfirmationPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MakeAppointmentPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAppointment {
    Account account;
    Appointment appointment;


    HomePage homePage;
    LoginPage loginPage;
    MakeAppointmentPage makeAppointmentPage;
    AppointmentConfirmationPage appointmentConfirmationPage;

    @BeforeClass
    public void setUp() {
        account = new Account();
        appointment = new Appointment();

        homePage = new HomePage();
        homePage.clickMakeAppointment();

        loginPage = new LoginPage();

        loginPage.login(account);

        makeAppointmentPage = new MakeAppointmentPage();
        appointmentConfirmationPage = new AppointmentConfirmationPage();
    }

    @AfterClass
    public void tearDown() {

    }

    @Test
    public void testMakeAppointment() {
        makeAppointmentPage.makeAppointment(appointment);
        appointmentConfirmationPage.compareAppointment(appointment, appointmentConfirmationPage.getAppointmentInfo());
    }
}
