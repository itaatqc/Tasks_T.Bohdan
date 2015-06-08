import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Xdr on 6/4/15.
 */


public class Test {
    private WebDriver driver;
    private Helper helper;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        helper = Helper.setDriver(driver);
    }

    @org.testng.annotations.Test
    public void search() {
        helper.enterThePage();
        helper.searchText("Banana");
        helper.getTextFromPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
