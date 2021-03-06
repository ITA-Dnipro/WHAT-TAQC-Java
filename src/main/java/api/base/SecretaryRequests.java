package api.base;

import constants.PathsToFiles;
import util.Role;
import util.User;

import java.io.IOException;

import static api.APIConstants.CREDENTIALS;
import static api.APIConstants.Headers.AUTHORIZATION;

public class SecretaryRequests extends BaseRequests {

    public SecretaryRequests() throws IOException {
        registeredUser = logIn(User.get(PathsToFiles.getProperty(CREDENTIALS))
                .get(Role.SECRETARY.getRoleName()));
        this.headers.put(AUTHORIZATION,
                registeredUser.getRoleList().get(Role.SECRETARY.getRoleName()));
    }
}
