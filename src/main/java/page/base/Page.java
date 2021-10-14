package page.base;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

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

    public abstract boolean isAt();

    public boolean isAt(long timeout, TimeUnit timeunit){
        try{
            await().atMost(timeout, timeunit)
                    .ignoreExceptions()
                    .until(() -> isAt());
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
