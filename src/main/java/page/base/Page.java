package page.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import java.util.logging.Logger;

/**
 * The base class for authorized users page objects.
 *
 * @author fresh-ash
 */
public abstract class Page extends BaseObject {

    protected Header header;

    protected SideBar sideBar;

    public Page(WebDriver driver) {
        super(driver);
        sideBar = new SideBar(driver);
        header = new Header(driver);
    }
}
