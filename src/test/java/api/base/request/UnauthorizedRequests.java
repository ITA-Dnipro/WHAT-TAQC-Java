package api.base.request;

import lessons.util.UserApi;
import util.User;

public class UnauthorizedRequests extends BaseRequests{

    public UserApi logIn(User user){
        return sendPost("/accounts/auth", user.toString()).body().as(UserApi.class);

    }
}
