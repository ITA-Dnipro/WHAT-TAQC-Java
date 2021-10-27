package api.services;

import api.base.BaseRequests;
import io.restassured.response.Response;
import static api.APIConstants.Student.*;
public class StudentServiceApi {
    BaseRequests baseRequests;

    public StudentServiceApi(BaseRequests baseRequests) {
        this.baseRequests = baseRequests;
    }
    public Response assignStudent(Integer id){
        return baseRequests.sendPost(STUDENT+id.toString(),"");
    }
}
