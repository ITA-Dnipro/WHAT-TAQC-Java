import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @BeforeClass
    public void preconditions(){
        driver.get("http://localhost:8080");
    }

    @Test
    public void redirectToRegistrationPage(){

        //Should use yours PageObjects
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//a[contains(@href, 'registration')]")).click();

        //Example for wait
        wait.until(url -> driver.getCurrentUrl().equals("http://localhost:8080/registration"));
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(true);
    }
}
