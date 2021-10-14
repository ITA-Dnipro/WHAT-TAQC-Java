package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import page.base.Page;

import java.io.IOException;

public abstract class User {

    protected String mail;
    protected String pass;

    public String getMail(){
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public abstract Object basePage(WebDriver driver);
}
