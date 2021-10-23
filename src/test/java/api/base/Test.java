package api.base;

import api.base.request.AdminRequests;
import api.lessons.LessonServiceApi;
import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lessons.util.UserApi;
import org.testng.annotations.BeforeClass;
import util.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Test extends BaseTestApi{


    @BeforeClass
    public void setup() {

    }

    @org.testng.annotations.Test
    public void getLessons(){
        LessonServiceApi lessonServiceApi = new LessonServiceApi();
        System.out.println(lessonServiceApi.getLessons());
    }
}
