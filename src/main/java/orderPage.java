import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class orderPage {

    private WebDriver driver;

    private By customerNameField = By.cssSelector(".col-lg-6 [id=\"customerName\"]");
    private By customerPhonenumberField = By.cssSelector(".col-lg-6 [id=\"customerPhonenumber\"]");
    private By customerEmailField = By.cssSelector(".col-lg-6 [id=\"customerEmail\"]");
    private By pickpointNog = By.cssSelector(".row .col-md-6:first-child .form-check:first-child");

    public orderPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getCustomerEmailField() {
        return customerEmailField;
    }

    public By getCustomerNameField() {
        return customerNameField;
    }

    public By getCustomerPhonenumberField() {
        return customerPhonenumberField;
    }

    public void customerNameFieldSendText(String text) {
        driver.findElement(customerNameField).sendKeys(text);
    }

    public void customerPhonenumberFieldSendText(String text) {
        driver.findElement(customerPhonenumberField).sendKeys(text);
    }

    public void customerEmailFieldSendText(String text) {
        driver.findElement(customerEmailField).sendKeys(text);
    }
}
