package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import constants.PathsToFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.base.LogIn;
import page.base.Page;
import page.lessons.LessonsPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestHelper {

    WebDriverWait wait;
    WebDriver driver;
    ObjectMapper mapper;
    Map<String, User> users ;
    Map<String, Page> defaultPages;

    public TestHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        users = new HashMap<>();
        mapper = new ObjectMapper();
        initDefaultPages();
        try{
            users = mapper.readValue(new File(PathsToFiles.CREDENTIALS),
                    new TypeReference<Map<String, User>>() {});
        }
        catch (IOException e){
            System.out.println("Wrong!");
        }
    }

    public < T extends Page> T logInAs(Role user){
        LogIn logIn = new LogIn(driver);
        logIn.fillMail(users.get(user.getRoleName()).getMail())
                .fillPass(users.get(user.getRoleName()).getPass())
                .clickLogInButton();
        waitForRedirectFrom(Endpoints.AUTH);
        return (T) defaultPages.get(user.getRoleName());
    }



    public User getUserByRole(Role role){
        return users.get(role.getRoleName());
    }

    private void initDefaultPages(){
        this.defaultPages = new HashMap<>();
        defaultPages.put("mentor", new LessonsPage(driver));
    }

    public ObjectMapper getMapper() {
        return mapper;
    }

    public void waitDownloadPage(String url){
        wait.until(redirect -> driver.getCurrentUrl().equals(url));
    }

    public void waitForRedirectFrom(String currentURL){
        wait.until(redirect -> !(driver.getCurrentUrl().equals(currentURL)));
    }

    public void waitForVisibilityOfElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
