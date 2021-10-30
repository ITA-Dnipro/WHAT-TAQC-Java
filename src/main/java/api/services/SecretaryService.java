package api.services;

import api.APIConstants;
import api.base.BaseRequests;
import io.restassured.response.Response;

public class SecretaryService {
    BaseRequests requests;

    public Response getSecretary() {
        return requests.sendGet(APIConstants.Secretary.SECRETARY);
    }

    public Response getActiveSecretary() {
        return requests.sendGet(APIConstants.Secretary.SECRETARY);
    }

    public Response deleteSecretary(Integer id) {
        return requests.sendDelete(APIConstants.Secretary.SECRETARY, id);
    }
}
