package testUI;

import org.openqa.selenium.WebDriver;
import page.base.Page;

public abstract class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public abstract <T extends Page> T getHomePageAdmin(WebDriver driver);

    public User(String email, String password, String lastName, String firstName) {
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


}
