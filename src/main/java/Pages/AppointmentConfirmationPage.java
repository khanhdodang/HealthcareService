package Pages;

import Objects.Appointment;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage extends BasePage {

    public AppointmentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * get Appointment Info
     * @return
     */
    public Appointment getAppointmentInfo() {
        Appointment appointment = new Appointment();

        return appointment;
    }

    public void compareAppointment(Appointment expected, Appointment actual) {

    }
}
