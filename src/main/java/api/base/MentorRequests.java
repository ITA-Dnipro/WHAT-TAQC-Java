package api.base;

import constants.PathsToFiles;
import util.Role;
import util.User;

import java.io.IOException;

import static api.APIConstants.CREDENTIALS;
import static api.APIConstants.Headers.AUTHORIZATION;

public class MentorRequests extends BaseRequests {

    public MentorRequests() throws IOException {
        registeredUser = logIn(User.get(PathsToFiles.getProperty(CREDENTIALS))
                .get(Role.MENTOR.getRoleName()));
        this.headers.put(AUTHORIZATION,
                registeredUser.getRoleList().get(Role.MENTOR.getRoleName()));
    }
}
