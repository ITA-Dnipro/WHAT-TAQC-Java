package api.services;

import api.base.BaseRequests;
import api.APIConstants;
import io.restassured.response.Response;

public class MentorsServiceApi {
    BaseRequests requests;

    public Response getGroupOfMentor(Integer id) {
        return requests.sendGet(APIConstants.Mentors.MENTORS, "/groups", id);
    }

    public Response getCourseOfMentor(Integer id) {
        return requests.sendGet(APIConstants.Mentors.MENTORS, APIConstants.Courses.COURSES_ENDPOINT, id);
    }

    public Response getMentors() {
        return requests.sendGet(APIConstants.Mentors.MENTORS);
    }

    public Response getMentorsById(Integer id) {
        return requests.sendGet(APIConstants.Mentors.MENTORS, "", id);
    }

    public Response getActiveMentors() {
        return requests.sendGet(APIConstants.Mentors.ACTIVE_MENTORS);
    }

    public Response deleteMentor(Integer id) {
        return requests.sendDelete(APIConstants.Mentors.MENTORS, id);
    }

    public Response enableMentor(Integer id) {
        return requests.sendPatch(APIConstants.Mentors.MENTORS, id,"");
    }

    public Response postAssignMentor(Integer id) {
        return requests.sendPost(APIConstants.Mentors.MENTORS+id.toString(),"");
    }

    public Response getListOfLessonsMentors(Integer id) {
        return requests.sendGet(APIConstants.Mentors.MENTORS,APIConstants.Lessons.LESSONS, id);
    }


    public MentorsServiceApi(BaseRequests requests) {
        this.requests = requests;
    }

    public BaseRequests getRequests() {
        return requests;
    }

    public void setRequests(BaseRequests requests) {
        this.requests = requests;
    }

}
