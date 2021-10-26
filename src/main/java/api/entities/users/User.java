package api.entities.users;

import util.RandomStringsGenerator;

public class User {

    protected String email;
    protected String firstName;
    protected String lastName;
    protected String password;
    protected String confirmPassword;

    public User() {
    }

    public User(String email, String firstName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = password;
    }

    public static User getUserWithRandomValues() {
        String firstName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        String lastName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        String password = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        String email = RandomStringsGenerator.getRandomEmail(5, "gmail.com");
        return new User(firstName, lastName, email, password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
