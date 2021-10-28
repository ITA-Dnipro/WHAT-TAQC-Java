package api.entities.users;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Map;

public class RegisteredUser {

    @JsonAlias("first_name")
    String firstName;

    @JsonAlias("last_name")
    String lastName;

    Integer role;
    Integer id;

    @JsonIgnore
    String token;

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
}
