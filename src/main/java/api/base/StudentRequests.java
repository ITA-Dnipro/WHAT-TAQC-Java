package api.base;

import constants.PathsToFiles;
import util.Role;
import util.User;

import java.io.IOException;

import static api.APIConstants.Headers.AUTHORIZATION;

public class StudentRequests extends BaseRequests {

    public StudentRequests() throws IOException {
        registeredUser = logIn(User.get(PathsToFiles.getPathToCredentials())
                .get(Role.STUDENT.getRoleName()));
        this.headers.put(AUTHORIZATION,
                registeredUser.getRoleList().get(Role.STUDENT.getRoleName()));
    }
}
