import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Xdr on 6/4/15.
 */
public class Helper {
    private WebDriver driver;
    private final Logger helperLogger = Logger.getLogger(Helper.class);

    private Helper(WebDriver driver) {
        this.driver = driver;
    }

    public static Helper setDriver(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new Helper(driver);
    }

    public void enterThePage() {
        driver.get("http://www.ask.com/");
        helperLogger.info("page loaded");
    }

    public void searchText(String text) {
        driver.findElement(By.id("search-box")).sendKeys(text);
        driver.findElement(By.id("sbut")).click();
    }

    /**
     * Get number of words in specified WebElement.
     *
     * @param word          word to search for.
     * @param element       element to search in.
     * @param caseSensitive true if case sensitive search, false if case insensitive search.
     * @return number of specified words in WebElement.
     */
    public int countWords(String word, WebElement element, boolean caseSensitive) {
        int count = 0;
        String text = element.getText();
        if (!caseSensitive) {
            text = text.toLowerCase();
        }
        Pattern p = Pattern.compile(word);
        Matcher m = p.matcher(text);
        while (m.find()) {
            count++;
        }
        return count;
    }

    /**
     * Get count of 'banana' words on page and on search results
     */
    public void getCount() {
//        get all "banana" words from whole page
        WebElement body = driver.findElement(By.tagName("body"));
        int wordsOnPage = countWords("banana", body, false);
        helperLogger.info("Number of 'banana' words on page: " + wordsOnPage);
        Reporter.log("Number of 'banana' words on page: " + wordsOnPage, true);
//        get all "banana" words from web-page search results
        WebElement searchRslts = driver.findElement(By.cssSelector("div.l-web-results.web-results.content-mid"));
        int wordsOnWebResults = countWords("banana", searchRslts, false);
        helperLogger.info("Number of 'banana' words on webresults: " + wordsOnWebResults);
        Reporter.log("Number of 'banana' words on webresults: " + wordsOnWebResults, true);
    }
}
