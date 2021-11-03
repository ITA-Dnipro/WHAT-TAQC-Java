package api.services;

import api.base.BaseRequests;
import api.entities.courses.Course;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import static api.APIConstants.Courses.COURSES;

public class CoursesServiceApi {

    BaseRequests requests;

    public CoursesServiceApi(BaseRequests requests) {
        this.requests = requests;
    }

    public Response addCourse(Course course) throws JsonProcessingException {
        return requests.sendPost(COURSES, new ObjectMapper().writeValueAsString(course));
    }

    public Response addExistCourse(Course course) throws JsonProcessingException {
        return requests.sendPost(COURSES, new ObjectMapper().writeValueAsString(course));
    }

    public Response getCourses() {
        return requests.sendGet(COURSES);
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }

    public Response updateCourse(Course course) throws JsonProcessingException {
        return requests.sendPut(COURSES, course.getId(), new ObjectMapper().writeValueAsString(course));
    }

    public Response deleteCourse (int id) throws JsonProcessingException {
        return requests.sendDelete(COURSES, id);
    }

    public Response enableCourse (Course course) throws JsonProcessingException {
        return requests.sendPatch(COURSES, course.getId(), new ObjectMapper().writeValueAsString(course));
    }
}
