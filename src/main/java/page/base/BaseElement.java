package page.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * The base object for customer page elements
 *
 * @author fresh-ash
 */
public abstract class BaseElement {

    protected WebDriver driver;
    protected final Logger log = Logger.getLogger(getClass());

    public BaseElement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void fillField(WebElement field, String text) {
        if(field.getAttribute("disabled") == null
                && field.getAttribute("readonly") == null){
            field.click();
            field.clear();
            hardClear(field);
            field.sendKeys(text);
       }
    }

    protected WebElement getItemFromMenu(List<WebElement> webElementList, String name) {
        return webElementList.stream()
                .filter(element -> name.equals(element.getText()))
                .findAny()
                .orElse(null);
    }

    protected void clickElement(WebElement element) {
        element.click();
    }

    private void hardClear(WebElement field){
        field.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }
}
