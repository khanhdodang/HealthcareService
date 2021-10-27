package Pages;

import Locators.MakeAppointmentLocators;
import Objects.Appointment;
import org.openqa.selenium.WebDriver;

public class MakeAppointmentPage extends BasePage {
    MakeAppointmentLocators locators = new MakeAppointmentLocators();

    public MakeAppointmentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * make Appointment
     *
     * @param appointment
     */
    public void makeAppointment(Appointment appointment) {
        selectDropdownByVisibleText(locators.DROPDOWN_FACILITY, appointment.getFacility());
        if (appointment.isHospitalReadmission()) {
            if (!isSelected(locators.CHECKBOX_HOSPITAL_READMISSION)) {
                click(locators.CHECKBOX_HOSPITAL_READMISSION);
            }
        }

        switch (appointment.getHealthcareProgram().toLowerCase()) {
            case "medicare":
                click(locators.RADIO_MEDICARE);
                break;
            case "medicaid":
                click(locators.RADIO_MEDICAID);
                break;
            case "none":
                click(locators.RADIO_NONE);
                break;
        }

        setText(locators.INPUT_VISIT_DATE, appointment.getVisitDate());
        setText(locators.TXT_COMMENT, appointment.getComment());
        click(locators.BUTTON_BOOK_APPOINTMENT);
    }
}
