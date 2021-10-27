package api.services;

import api.APIConstants;
import api.base.BaseRequests;
import io.restassured.response.Response;

public class StudentServiceApi {
    BaseRequests baseRequests;

    public StudentServiceApi(BaseRequests baseRequests) {
        this.baseRequests = baseRequests;
    }
    public Response assignStudent(Integer id){
        return baseRequests.sendPost(APIConstants.Student.STUDENT+id.toString(),"");
    }
}
