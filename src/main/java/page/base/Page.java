package page.base;

import org.openqa.selenium.WebDriver;

/**
 * The base class for authorized users page objects.
 *
 * @author fresh-ash
 */
public abstract class Page extends BasePage {

    protected Header header;

    protected SideBar sideBar;

    public Page(WebDriver driver) {
        super(driver);
        sideBar = new SideBar(driver);
        header = new Header(driver);
    }

    public Header getHeader() {
        return header;
    }

    public SideBar getSideBar() {
        return sideBar;
    }
}
