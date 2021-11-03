package util;

import api.entities.users.User;

public class UnassignedUser extends User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UnassignedUser(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public static UnassignedUser getUnassignedUser(String firstName, String lastName, String email, String password){
        return new UnassignedUser(firstName, lastName, email, password);
    }
    public static UnassignedUser getUnassignedUser(){
        User user = User.getUserWithRandomValues();
        return new UnassignedUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }
}
