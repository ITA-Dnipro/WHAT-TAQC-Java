package base;

import constants.Endpoints;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {

    protected final Logger log = Logger.getLogger(getClass());
    protected WebDriver driver;
    protected long waitTime;

    @BeforeTest
    protected void setup() {
        WebDriverManager.chromedriver().setup();
        log.info("Chromedriver is set up");
    }

    @BeforeClass
    protected void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        waitTime = 2;
        driver.get(Endpoints.BASE_URL);
        log.info("Initialise web driver");
    }

    @AfterClass
    protected void teardown() {
        driver.quit();
        log.info("Quit");
    }
}
