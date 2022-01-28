import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchingResultsPage {

    private WebDriver webdriver;

    private By partNumber = By.cssSelector(".display-grid .mb-30 .text-dark");
    private By elementDescription = By.cssSelector(".display-grid .mb-30 .card-title a");

    public searchingResultsPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void clickElementDescription() {
        webdriver.findElement(elementDescription).click();
    }


    //element waiting

    public void waitForPartNumber(int seconds) {
        new WebDriverWait(webdriver, seconds)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".display-grid .mb-30 .text-dark")));
    }

    public String partNumberToString() {
        return webdriver.findElement(By.cssSelector(".display-grid .mb-30 .text-dark")).getText().toLowerCase();
    }

    public String descriptionToString() {
        return webdriver.findElement(elementDescription).getAttribute("title").toLowerCase();
    }

}
