package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void fillField(WebElement field, String text){
        field.click();
        field.clear();
        field.sendKeys(text);
    }

    protected void clickItem(WebElement element){
        element.click();
    }
}
