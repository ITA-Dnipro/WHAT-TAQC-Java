package page.unauthorizedUserPages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface Waiter {
    public default void waitUntilElementVisibility(WebDriver driver, WebElement element, Duration time){
        WebDriverWait waiter = new WebDriverWait(driver, time);
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
}
