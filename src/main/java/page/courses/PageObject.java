package page.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {

   protected WebDriver driver;

   public PageObject(WebDriver driver) {
       this.driver = driver;
   }

   protected void openUrl(String url) {
           driver.get(url);
   }

   protected WebElement find (By locator) {
       return driver.findElement(locator);
   }

   protected void click(By locator) {
       find(locator).click();
   }

   void type(String text, By locator) {
       find(locator).sendKeys(text);
   }

   public String getCurrentUrl() {
       return driver.getCurrentUrl();
   }
}

