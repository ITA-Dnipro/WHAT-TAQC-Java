package page.registrationPage;

import page.base.User;

public class UserRegistration extends User {

    private String password;

    public UserRegistration(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
