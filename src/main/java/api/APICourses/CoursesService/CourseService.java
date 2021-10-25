package api.APICourses.CoursesService;

import api.BaseCommands;
import constants.PathsToFiles;
import static io.restassured.RestAssured.*;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import util.Role;
import util.User;

import java.io.IOException;

import static api.APIConstants.APIEndpoints.AUTH_ENDPOINT;
import static api.APIConstants.APIEndpoints.COURSES_ENDPOINT;
import static api.APIConstants.baseConstants.*;

public class CourseService extends BaseCommands {
    private String validRequest = "{\"email\":\"james.smith@example.com\",\n" + "\"password\": \"_JkcG9dB\"}";
    private String authToken;

    public String getToken() throws IOException {
        Response response = given()
                .header(CONTENT_TYPE, APPLICATION_JSON)
                .body(validRequest)
                .when()
                .post(AUTH_ENDPOINT)
                .then()
                .extract().response();
        return authToken = response.getHeader(HEADER_AUTHORIZATION);
    }

    public Integer addNewCourse(String authToken) {
        defaultParser = Parser.JSON;
        Response resp = postCommand(APPLICATION_JSON, "cccourses", COURSES_ENDPOINT, authToken);
        return resp.statusCode();
    }
}



