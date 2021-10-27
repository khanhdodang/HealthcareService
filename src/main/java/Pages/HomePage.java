package Pages;

import Locators.HomeLocators;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    HomeLocators locators = new HomeLocators();

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * click Make Appointment button
     */
    public void clickMakeAppointment() {
        click(locators.BUTTON_MAKE_APPOINTMENT);
    }
}
