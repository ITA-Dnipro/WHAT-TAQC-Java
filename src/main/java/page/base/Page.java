package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

/**
 * The base class for authorized users page objects.
 *
 * @author fresh-ash
 */
public abstract class Page<I extends Page<I>> extends BasePage {

    protected Header header;
    protected SideBar sideBar;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        super(driver);
        sideBar = new SideBar(driver);
        header = new Header(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public <T> I redirectTo(String url, Class<T> type){
        driver.get(url);
        wait.until(r -> driver.getCurrentUrl().equals(url));
        return (I) new P(driver);
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
