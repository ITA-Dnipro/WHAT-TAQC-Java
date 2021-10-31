package api.services;

import api.base.BaseRequests;
import api.entities.courses.Course;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import static api.APIConstants.Courses.COURSES_ENDPOINT;

public class CoursesServiceApi {

    BaseRequests requests;

    public CoursesServiceApi(BaseRequests requests) {
        this.requests = requests;
    }

    public Response addCourse(Course course) throws JsonProcessingException {
        return requests.sendPost(COURSES_ENDPOINT, new ObjectMapper().writeValueAsString(course));
    }

    public Response getCourses() {
        return requests.sendGet(COURSES_ENDPOINT);
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }
}
