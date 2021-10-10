package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestHelper {

    WebDriverWait wait;
    WebDriver driver;

    public TestHelper(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        this.driver = driver;
    }

    public void waitDownloadPage(String url){
        wait.until(redirect -> driver.getCurrentUrl().equals(url));
    }

    public void waitForRedirect(String currentURL){
        wait.until(redirect -> !(driver.getCurrentUrl().equals(currentURL)));
    }

    public void waitForVisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
