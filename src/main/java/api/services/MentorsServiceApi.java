package api.services;

import api.base.BaseRequests;

import static api.APIConstants.Courses.*;
import static api.APIConstants.Mentors.*;
import static api.APIConstants.Lessons.*;
import static api.APIConstants.EMPTY_STRING;

import com.fasterxml.jackson.core.JsonProcessingException;
import api.entities.mentors.Mentor;
import io.restassured.response.Response;

public class MentorsServiceApi extends BaseService {


    public MentorsServiceApi(BaseRequests requests) {
        super(requests);
    }

    public Response getGroupOfMentor(Integer id) {
        return requests.sendGet(MENTORS, GROUPS, id);
    }

    public Response getCourseOfMentor(Integer id) {
        return requests.sendGet(MENTORS, COURSES_ENDPOINT, id);
    }

    public Response getMentors() {
        return requests.sendGet(MENTORS);
    }

    public Response getMentorsById(Integer id) {
        return requests.sendGet(MENTORS, EMPTY_STRING, id);
    }

    public Response getActiveMentors() {
        return requests.sendGet(ACTIVE_MENTORS);
    }

    public Response deleteMentor(Integer id) {
        return requests.sendDelete(MENTORS, id);
    }

    public Response enableMentor(Integer id) {
        return requests.sendPatch(MENTORS, id, EMPTY_STRING);
    }

    public Response postAssignMentor(Integer id) {
        return requests.sendPost(MENTORS + id.toString(), EMPTY_STRING);
    }

    public Response getListOfLessonsMentors(Integer id) {
        return requests.sendGet(MENTORS, LESSONS, id);
    }

    public Response editMentor(Mentor mentor) throws JsonProcessingException {
        return requests.sendPut(MENTORS, mentor.getId(), mapper.writeValueAsString(mentor));
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }

}
