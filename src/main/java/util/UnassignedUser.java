package util;

public class UnassignedUser {
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
        String firstName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        String lastName = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        String password = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        String email = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        return new UnassignedUser(firstName, lastName, email, password);
    }
}
