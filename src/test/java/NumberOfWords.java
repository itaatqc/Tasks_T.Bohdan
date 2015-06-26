import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


/**
 * Created by Xdr on 6/4/15.
 */

public class NumberOfWords {
    private WebDriver driver;
    private Helper helper;


    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        helper = Helper.setDriver(driver);
    }

    @Test
    public void search() {
        helper.enterThePage();
        helper.searchText("Banana");
        helper.getCount();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
