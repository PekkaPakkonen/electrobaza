import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class categoryPage {

    private WebDriver webdriver;

    private By categoryPageTitle = By.cssSelector(".col .d-flex .font-weight-bold");
    private By categoryPageDescription = By.cssSelector(".catalog-footer-text p");

    public categoryPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public By getCategoryPageTitle() {
        return categoryPageTitle;
    }

    public By getCategoryPageDescription() {
        return categoryPageDescription;
    }

    public String getCategoryPageDescriptionText() {
        return webdriver.findElement(categoryPageDescription).getText().toLowerCase();
    }

    public void waitForElement(By element) {
        new WebDriverWait(webdriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }


}
