package api.base;

import constants.PathsToFiles;
import util.Role;
import util.User;

import java.io.IOException;

import static api.APIConstants.CREDENTIALS;
import static api.APIConstants.Headers.AUTHORIZATION;

public class AdminRequests extends BaseRequests {

    public AdminRequests() throws IOException {
        registeredUser = logIn(User.get(PathsToFiles.getProperty(CREDENTIALS))
                .get(Role.ADMIN.getRoleName()));
        this.headers.put(AUTHORIZATION,
                registeredUser.getRoleList().get(Role.ADMIN.getRoleName()));
    }
}
