import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTest {

    private WebDriver driver;
    private JavascriptExecutor js;
    private cartPage cartP;
    private orderPage orderP;

    @BeforeTest
    public void preps() throws InterruptedException {
        driver = new FirefoxDriver();
        cartP = new cartPage(driver);
        orderP = new orderPage(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://test.electrobaza.ru/cart");
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(cartP.getProductField()));
    }

    @Test
    public void orderByCash() throws InterruptedException {
        cartP.sendTextProductField("mccb99-160-125");
        cartP.clickAddProductBtn();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(cartP.getItemTitle()));
        while(!driver.findElement(cartP.getFormOrderBtn()).isEnabled()) {

        }
        cartP.clickFormOrderBtn();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(orderP.getCustomerEmailField()));
        orderP.customerEmailFieldSendText("test@mail.ru");
        orderP.customerNameFieldSendText("Test");
        orderP.customerPhonenumberFieldSendText("8005553535");
    }
}

