import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementPage {

    private WebDriver webdriver;

    private By itemDescriptionTab = By.cssSelector(".tabs .nav-item:nth-child(2)");
    private By itemDocumentsTab = By.cssSelector(".tabs .nav-item:nth-child(3)");
    private By reviewTab = By.cssSelector(".tabs .nav-item:nth-child(4)");
    private By reviewText = By.cssSelector(".item-reviews .d-flex.mb-30 .mb-1");
    private By activeTabDescription = By.cssSelector(".tab-pane.active p");
    private By activeTab = By.cssSelector(".tab-pane.active");
    private By docs = By.cssSelector(".tab-pane.active .text-reset");

    public elementPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public void waitItemDescriptionTab() {
        new WebDriverWait(webdriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tabs .nav-item:nth-child(2)")));
    }

    public void clickItemDescriptionTab() {
        webdriver.findElement(itemDescriptionTab).click();
    }

    public void clickItemDocumentsTab() {
        webdriver.findElement(itemDocumentsTab).click();
    }

    public void clickReviewTab() {
        webdriver.findElement(reviewTab).click();
    }

    public String getDescriptionText() {
        return webdriver.findElement(activeTabDescription).getText().toLowerCase();
    }

    public String[] documentsTitles() {
        WebElement[] elements = webdriver.findElements(docs).toArray(new WebElement[0]);
        String[] titles = new String[elements.length];
        for(int i = 0; i < elements.length; i++) {
            titles[i] = elements[i].getText().toLowerCase();
        }
        return titles;
    }

    public String[] reviewText() {
        WebElement[] elements = webdriver.findElements(reviewText).toArray(new WebElement[0]);
        String[] texts = new String[elements.length];
        for(int i = 0; i < elements.length; i++) {
            texts[i] = elements[i].getText().toLowerCase();
        }
        return texts;
    }



}
