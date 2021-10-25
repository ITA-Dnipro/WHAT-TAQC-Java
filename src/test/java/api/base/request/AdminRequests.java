package api.base.request;

import lessons.util.UserApi;
import util.User;

public class AdminRequests extends BaseRequests{

    UserApi user;

    public AdminRequests(User user) {
        this.user = new UnauthorizedRequests().logIn(user);
        this.headers.put("Authorization", this.user.getRoleList().get("admin"));
        setHeaders(this.headers);
    }


}
