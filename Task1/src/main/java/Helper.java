import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xdr on 6/4/15.
 */
public class Helper {
    private WebDriver driver;

    private Helper(WebDriver driver) {
        this.driver = driver;
    }

    public static Helper setDriver(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new Helper(driver);
    }

    public void enterThePage() {
        driver.get("http://www.ask.com/");
    }

    public void searchText(String text) {
        driver.findElement(By.id("search-box")).sendKeys(text);
        driver.findElement(By.id("sbut")).click();
    }

    public void getTextFromPage() {
        getCount();
        System.out.println();
    }

    public int countWords(String word, WebElement element, boolean caseSensitive) {
        int count = 0;
        String text = element.getText();
        if(!caseSensitive){
            text = text.toLowerCase();
        }
        while (text.contains(word)){
            count++;
            text = text.substring(text.indexOf(word) + word.length());
        }
        System.out.println(count);
        return count;
    }

    public void getCount(){
//        get all "banana" words from whole page
        WebElement body = driver.findElement(By.tagName("body"));
        countWords("banana",body,false);
//        get all "banana" words from web-page search results
        WebElement searchRslts = driver.findElement(By.cssSelector("div.l-web-results.web-results.content-mid"));
        countWords("banana", searchRslts,false);
    }
}
