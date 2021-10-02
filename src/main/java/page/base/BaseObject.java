package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * The base object for customer page elements
 * @author fresh-ash
 * */
public abstract class BaseObject {

    protected WebDriver driver;

    public BaseObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void fillField(WebElement field, String text){
        field.click();
        field.clear();
        field.sendKeys(text);
    }

    protected WebElement getItemFromMenu(List<WebElement> webElementList, String name){
        return webElementList.stream()
                .filter(element -> name.equals(element.getText()))
                .findAny()
                .orElse(null);
    }

    protected void clickElement(WebElement element){
        element.click();
    }
}
