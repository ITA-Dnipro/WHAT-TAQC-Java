package api.entities.users;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;

public class RegisteredUser {

    @JsonAlias({"first_name"})
    String firstName;
    @JsonAlias({"last_name"})
    String lastName;
    @JsonAlias({"active"})
    protected Boolean isActive;
    protected Integer id;
    protected String email;
    protected Integer role;
    protected String token;
    protected String avatarUrl;
    protected String password;

    Map<String,String> roleList;

    public Map<String, String> getRoleList() {
        return roleList;
    }

    public void setRoleList(Map<String, String> roleList) {
        this.roleList = roleList;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", token='" + token + '\'' +
                ", password='" + password + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
