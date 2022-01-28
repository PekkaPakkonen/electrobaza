import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchTest {

    private WebDriver driver;
    private mainPage mainP;
    private searchingResultsPage searchP;
    private elementPage elementP;
    private categoryPage categoryP;
    private String[] requests = {"mcb",
            "dsrk.xfntkm",
            "lampa",
            "паспорт трансформатор",
            "отличное качество",
            "автамат",
            "выкл"
    };

    @BeforeSuite
    public void preps() {
        driver = new FirefoxDriver();
        mainP = new mainPage(driver);
        searchP = new searchingResultsPage(driver);
        elementP = new elementPage(driver);
        categoryP = new categoryPage(driver);
        driver.manage().window().maximize();
        driver.get("https://electrobaza.ru/");
        mainP.waitForElement(mainP.getAgreeBtn());

    }

    @AfterMethod
    public void returnToMainPage() {
        driver.get("https://electrobaza.ru/");
        mainP.waitForElement(mainP.getAgreeBtn());
    }

    @Test
    public void partialArticleTest() {
        mainP.sendSearchText(requests[0]);
        mainP.clickSearchButton();
        searchP.waitForPartNumber(20);
        String str = searchP.partNumberToString();
        Assert.assertTrue(str.contains(requests[0]));
    }

    @Test
    public void fixKeyboardLayoutTest() {
        String fixedRequest = "выключатель";

        mainP.sendSearchText(requests[1]);
        mainP.clickSearchButton();
        searchP.waitForPartNumber(20);
        String str = searchP.descriptionToString();

        Assert.assertTrue(str.contains(fixedRequest));
    }

    @Test
    public void transliterationInputTest() {
        String cyrillicRequest = "лампа";

        mainP.sendSearchText(requests[2]);
        mainP.clickSearchButton();
        searchP.waitForPartNumber(20);
        String str = searchP.descriptionToString();

        Assert.assertTrue(str.contains(cyrillicRequest));
    }

    @Test
    public void productDescriptionTest() {
        String productDescription = "c жидкокристаллическим дисплеем является устройством";

        mainP.sendSearchText(productDescription);
        mainP.clickSearchButton();
        searchP.waitForPartNumber(20);
        searchP.clickElementDescription();
        elementP.waitItemDescriptionTab();
        elementP.clickItemDescriptionTab();
        String str = elementP.getDescriptionText();

        Assert.assertTrue(str.contains(productDescription));
    }

    @Test(enabled = false)
    public void categoryDescriptionTest() {
        //doesn't work properly as website search can't find category pages by part of category description
        String categoryDescription = "Модульный автоматический выключатель – " +
                "гарантия стабильной работы электросетей в частных домах, квартирах и на предприятиях.";
        mainP.sendSearchText(categoryDescription);
        mainP.waitForElement(mainP.getCategoriesSearch());
        mainP.clickCategoriesFirstResult();
        categoryP.waitForElement(categoryP.getCategoryPageDescription());
        String str = categoryP.getCategoryPageDescriptionText();

        Assert.assertTrue(str.contains(categoryDescription.toLowerCase()));
    }

    @Test
    public void itemDocumentsTest() {
        String[] words = requests[3].toLowerCase().split(" ");
        boolean isAtLeastOneWord = false;
        mainP.sendSearchText(requests[3]);
        mainP.clickSearchButton();

        searchP.waitForPartNumber(20);
        String str = searchP.descriptionToString();
        for(String word : words) {
            if(str.contains(word)) {
                isAtLeastOneWord = true;
                break;
            }
        }
        if(!isAtLeastOneWord) Assert.fail();
        searchP.clickElementDescription();

        elementP.waitItemDescriptionTab();
        elementP.clickItemDocumentsTab();
        String[] documents = elementP.documentsTitles();
        for(String doc : documents) {
            for( String word : words) {
                if (doc.contains(word)) return;
            }
        }
        Assert.fail();
    }

    @Test
    public void reviewsTest() {
        mainP.sendSearchText(requests[4]);
        mainP.clickSearchButton();
        searchP.waitForPartNumber(20);
        searchP.clickElementDescription();
        elementP.waitItemDescriptionTab();
        elementP.clickReviewTab();

        String[] texts = elementP.reviewText();
        for(String text : texts) {
            System.out.println(text);
            if (text.contains(requests[4])) return;
        }
        Assert.fail();
    }

    @Test
    public void typoTest() {
        String fixedWord = "автомат";
        mainP.sendSearchText(requests[5]);
        mainP.clickSearchButton();
        searchP.waitForPartNumber(20);
        String str = searchP.descriptionToString();

        Assert.assertTrue(str.contains(fixedWord));

    }

    @Test
    public void categoryShowTest() {
        mainP.sendSearchText(requests[6]);
        mainP.waitForElement(mainP.getCategoriesSearch());

    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
