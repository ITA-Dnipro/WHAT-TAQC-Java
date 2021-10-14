package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import util.TestHelper;
import util.Users;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected TestHelper helper;

    @BeforeSuite
    protected static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    protected void setupTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        helper = new TestHelper(driver);
    }

    @AfterClass
    protected void teardown() {
        driver.quit();
    }
}
