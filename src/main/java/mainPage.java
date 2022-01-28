import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class mainPage {

    private WebDriver webdriver;

    private By catalogOpenBtn = By.cssSelector(".navbar .d-flex .btn.navbar-toggler");
    private By availableCatalogSection = By.cssSelector(".mainmenu-panel.level-1 .mainmenu-item:not(.d-lg-none)");
    private By agreeBtn = By.cssSelector(".dropdown-menu .btn-group .btn-success");
    private By searchText = By.cssSelector(".navbar-collapse .navbar-search .form-control");
    private By searchBtn = By.cssSelector(".navbar-collapse .navbar-search .btn");
    private By categoriesSearch = By.cssSelector(".show .list-group.categories");
    private By categoriesFirstResult = By.cssSelector(".show .list-group.categories .list-group-item.w-100");

    public mainPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
//GETTERS
    public By getCatalogOpenBtn() {
        return catalogOpenBtn;
    }

    public By getAvailableCatalogSection() {
        return availableCatalogSection;
    }

    public By getAgreeBtn() {
        return agreeBtn;
    }

    public By getSearchText() {
        return searchText;
    }

    public By getSearchBtn() {
        return searchBtn;
    }

    public By getCategoriesSearch() {
        return categoriesSearch;
    }

    public By getCategoriesFirstResult() {
        return categoriesFirstResult;
    }

    //BUTTON CLICKERS
    public void clickCatalogOpenBtn() {
        webdriver.findElement(catalogOpenBtn).click();
    }

    public void clickAgreeBtn() {
        webdriver.findElement(agreeBtn).click();
    }

    public void clickSearchButton() {
        webdriver.findElement(searchBtn).click();
    }

    public void clickCategoriesFirstResult() {webdriver.findElement(categoriesFirstResult).click();}

//OTHER STUFF
    public WebElement[] AvailableCatalogSections(){
        return webdriver.findElements(availableCatalogSection).toArray(new WebElement[0]);
    }

    public void waitForElement(By element) {
        new WebDriverWait(webdriver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void moveMouseToGroupHeader(WebElement webElement) {
        Actions action = new Actions(webdriver);
        action.moveToElement(webElement).perform();
    }

    public void sendSearchText(String text) {
        webdriver.findElement(searchText).sendKeys(text);
    }
 }
