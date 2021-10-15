package page.base;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.StudentsPage;
import page.lessons.LessonsPage;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
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

    public <T> T redirectTo(String url, Class<T> type){
        driver.get(url);
        wait.until(r -> driver.getCurrentUrl().equals(url));
        return (T) type.cast(Endpoints.getPages(driver).get(url));
    }

    public Header getHeader() {
        return header;
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public abstract boolean isAt();

    public I isAtPage(long timeout){
        try{
            await().atMost(timeout, TimeUnit.SECONDS)
                    .ignoreExceptions()
                    .until(() -> isAt());
            return (I) this;
        }catch(Exception e){
            return  null;
        }
    }

    public Auth logOut() throws IOException {
        return header.logOut();
    }
}
