package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import java.util.List;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        return driver;
    }

    /**
     * Navigate to the URL
     *
     * @param url Input the URL to navigate
     */
    public void navigate(String url) {
        driver.get(url);
    }

    /**
     * Get current URL
     */
    public String getUrl() {
        Reporter.log("Get current URL");
        return driver.getCurrentUrl();
    }

    /**
     * Check element displays or not
     *
     * @param by
     * @return
     */
    public boolean isDisplayed(By by) {
        Reporter.log("Check if the element exists");
        try {
            WebElement element = driver.findElement(by);
            return element.isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Check element checked or not
     *
     * @param by
     * @return
     */
    public boolean isSelected(By by) {
        Reporter.log("Check if the element checked");
        try {
            WebElement element = driver.findElement(by);
            return element.isSelected();
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * Get text of an element
     *
     * @param by receive the element
     */
    public String getText(By by) {
        Reporter.log("Get text on the element by locator " + by.toString());
        WebElement element = driver.findElement(by);
        return element.getText();
    }

    /**
     * Click on an element
     *
     * @param by receive the element
     */
    public void click(By by) {
        Reporter.log("Click on the element by locator " + by.toString());
        WebElement element = driver.findElement(by);
        element.click();
    }

    /**
     * Set text into element
     *
     * @param by   the element
     * @param text the value
     */
    public void setText(By by, String text) {
        Reporter.log("Set text on the element by locator " + by.toString() + " with the value: " + text);
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Get element size
     *
     * @param by the element
     */
    public int getElementsSize(By by) {
        int result = 0;
        try {
            List<WebElement> elementList = driver.findElements(by);
            result = elementList.size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    /**
     * Select dropdown by index
     *
     * @param by
     * @param index start index = 1
     */
    public void selectDropdown(By by, int index) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    /**
     * Select dropdown by value
     *
     * @param by
     * @param value
     */
    public void selectDropdownByValue(By by, String value) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }

    /**
     * Select dropdown by visible text
     *
     * @param by
     * @param VisibleText
     */
    public void selectDropdownByVisibleText(By by, String VisibleText) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(VisibleText);
    }

    /**
     * Terminate test session
     */
    public void cleanUp() {
        driver.quit();
    }
}
