package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {

    WebDriverWait wait;
    WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void waitDownloadPage(String url){
        wait.until(redirect -> driver.getCurrentUrl().equals(url));
    }

    public void waitForRedirectFrom(String currentURL){
        wait.until(redirect -> !(driver.getCurrentUrl().equals(currentURL)));
    }

    public void waitForVisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
