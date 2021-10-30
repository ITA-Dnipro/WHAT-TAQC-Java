package api.services;

import api.APIConstants;
import api.base.BaseRequests;
import io.restassured.response.Response;

import static api.APIConstants.EMPTY_STRING;
import static api.APIConstants.Secretary.SECRETARY;

public class SecretaryServiceApi {
    BaseRequests requests;

    public Response getSecretary() {
        return requests.sendGet(APIConstants.Secretary.SECRETARY);
    }

    public Response getActiveSecretary() {
        return requests.sendGet(APIConstants.Secretary.SECRETARY);
    }

    public Response postAssignSecretary(Integer id) {
        return requests.sendPost(SECRETARY + id.toString(), EMPTY_STRING);
    }

    public SecretaryServiceApi(BaseRequests requests) {
        this.requests = requests;
    }

    public Response deleteSecretary(Integer id) {
        return requests.sendDelete(APIConstants.Secretary.SECRETARY, id);
    }
}
