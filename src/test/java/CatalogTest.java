import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CatalogTest {

    private WebDriver driver;
    private JavascriptExecutor js;
    private mainPage mainP;

    @BeforeTest
    public void preps() throws InterruptedException {
        driver = new FirefoxDriver();
        mainP = new mainPage(driver);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://test.electrobaza.ru/");
        mainP.waitForElement(mainP.getAgreeBtn());
        mainP.clickAgreeBtn();
        Thread.sleep(1000);
    }

    @Test
    public void click() throws InterruptedException {
        mainP.clickCatalogOpenBtn();
        mainP.waitForElement(mainP.getAvailableCatalogSection());
        WebElement[] elements = mainP.AvailableCatalogSections();
        for(int i = 0; i < elements.length; i++) {
            js.executeScript("arguments[0].scrollIntoView(true);", elements[i]);
            mainP.moveMouseToGroupHeader(elements[i]);
            Thread.sleep(1000);
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".panel-content.list-unstyled.open")));
            WebElement[] getSectionMenus = elements[i].findElements(By.cssSelector(".panel-content.list-unstyled.open .mainmenu-item"))
                    .toArray(new WebElement[0]);
            System.out.println(getSectionMenus.length);
           /* for(WebElement element : getSectionMenus) {
                js.executeScript("window.open('arguments[0]');", element.getAttribute("href"));
                driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[1]);
                driver.close();
                driver.switchTo().window(driver.getWindowHandles().toArray(new String[0])[0]);
            }*/
        }
    }


    @AfterTest
    public void quit() {
        driver.quit();
    }
}
