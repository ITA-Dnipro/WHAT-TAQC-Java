package api.entities.users;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;

public class RegisteredUser {

    @JsonAlias({"first_name", "firstName"})
    String firstName;

    @JsonAlias({"last_name", "lastName"})
    String lastName;

    Integer role;
    Integer id;

    @JsonIgnore
    String token;
    protected Boolean isActive;

    protected String email;

    Map<String,String> roleList;

    public Map<String, String> getRoleList() {
        return roleList;
    }

    public void setRoleList(Map<String, String> roleList) {
        this.roleList = roleList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", id=" + id +
                ", token='" + token + '\'' +
                ", isActive=" + isActive +
                ", email='" + email + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
