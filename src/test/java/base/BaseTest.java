package base;

import constants.Endpoints;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected long waitTime;

    @BeforeSuite
    protected static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    protected void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        waitTime = 2;
        driver.get(Endpoints.AUTH);
    }

    @AfterClass
    protected void teardown() {
        driver.quit();
    }
}
