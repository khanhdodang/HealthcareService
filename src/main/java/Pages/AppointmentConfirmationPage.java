package Pages;

import Locators.AppointmentConfirmationLocators;
import Objects.Appointment;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AppointmentConfirmationPage extends BasePage {
    AppointmentConfirmationLocators locators = new AppointmentConfirmationLocators();

    public AppointmentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    /**
     * get Appointment Info
     *
     * @return
     */
    public Appointment getAppointmentInfo() {
        Appointment appointment = new Appointment();
        appointment.setFacility(getText(locators.LABEL_FACILITY));
        String hospitalReadmission = getText(locators.LABEL_HOSPITAL_READMISSION);
        appointment.setHospitalReadmission(false);
        if (hospitalReadmission.equalsIgnoreCase("yes")) {
            appointment.setHospitalReadmission(true);
        }
        appointment.setHealthcareProgram(getText(locators.LABEL_PROGRAM));
        appointment.setVisitDate(getText(locators.LABEL_VISIT_DATE));
        appointment.setComment(getText(locators.LABEL_COMMENT));
        return appointment;
    }

    /**
     * Compare two Appointments in detail
     *
     * @param actual   Appointment
     * @param expected Appointment
     */
    public void compareAppointment(Appointment actual, Appointment expected) {
        Assert.assertEquals(actual.getFacility(), expected.getFacility());
        Assert.assertEquals(actual.isHospitalReadmission(), expected.isHospitalReadmission());
        Assert.assertEquals(actual.getHealthcareProgram(), expected.getHealthcareProgram());
        Assert.assertEquals(actual.getVisitDate(), expected.getVisitDate());
        Assert.assertEquals(actual.getComment(), expected.getComment());
    }
}
