package api.auth.data;

import java.util.Map;

public class AuthResponseBody {
    private String first_name;
    private String last_name;
    private String role;
    private Map <String, String> roleList;

    public AuthResponseBody(String first_name, String last_name, String role, Map<String, String> roleList) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
        this.roleList = roleList;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map <String, String> getRoleList() {
        roleList.get("admin");
        return roleList;
    }

    public void setRoleList(Map<String, String> roleList) {
        this.roleList = roleList;
    }
}
