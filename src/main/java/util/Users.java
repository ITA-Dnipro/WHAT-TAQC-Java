package util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.PathsToFiles;
import page.base.Page;
import page.students.StudentsPage;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Users {

    Map<String, User> users;
    Map<String, Class<?>> pages;
    public Users() {
        try {
            this.users = new ObjectMapper().readValue(new File(PathsToFiles.CREDENTIALS),
                    new TypeReference<Map<String, User>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        pages.put(Role.ADMIN.getRoleName(), StudentsPage.class);
    }

    public User getUser(Role role){
        return users.get(role.getRoleName());
    }

}
