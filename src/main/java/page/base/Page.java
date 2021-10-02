package page.base;

import org.openqa.selenium.WebDriver;

/**
 * The base class for authorized users page objects.
 * @author fresh-ash
 * */
public abstract class Page extends BaseObject{

    protected SideBar sideBar;

    public Page(WebDriver driver) {
        super(driver);
        sideBar = new SideBar(driver);
    }

}
