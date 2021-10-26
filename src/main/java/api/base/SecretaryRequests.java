package api.base;

import constants.PathsToFiles;
import util.Role;
import util.User;

import java.io.IOException;

import static api.APIConstants.Headers.AUTHORIZATION;

public class SecretaryRequests extends BaseRequests {

    public SecretaryRequests() throws IOException {
        registeredUser = logIn(User.get(PathsToFiles.getPathToCredentials())
                .get(Role.SECRETARY.getRoleName()));
        this.headers.put(AUTHORIZATION,
                registeredUser.getRoleList().get(Role.SECRETARY.getRoleName()));
    }
}
