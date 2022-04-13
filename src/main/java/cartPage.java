import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage {

    private WebDriver driver;

    private By productField = By.cssSelector(".input-group .rounded-0.py-3");
    private By addProductBtn = By.cssSelector(".input-group-text .btn");
    private By itemTitle = By.cssSelector(".font-weight-bold.pr-md-0");
    private By formOrderBtn = By.cssSelector(".btn.btn-block.text-uppercase");

    public cartPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getProductField() {
        return productField;
    }

    public By getItemTitle() {
        return itemTitle;
    }

    public By getFormOrderBtn() {
        return formOrderBtn;
    }

    public void clickAddProductBtn() {
        driver.findElement(addProductBtn).click();
    }
    public void clickFormOrderBtn() {
        driver.findElement(formOrderBtn).click();
    }

    public void sendTextProductField(String text) {
        driver.findElement(productField).sendKeys(text);
    }

}
