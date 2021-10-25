package api;

import api.APICourses.coursesData.CourseAddName;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.defaultParser;
import static io.restassured.RestAssured.given;

public class BaseCommands {

    public Response postCommand(String type, String name, String endpoint, String token) {
        defaultParser = Parser.JSON;
        return given().contentType(type)
                .header("Authorization", token)
                .body(new CourseAddName(name))
                .when()
                .post(endpoint);
    }

//    public ValidatableResponse getResponse(String method, String url) {
//        defaultParser = Parser.JSON;
//        ValidatableResponse response = when().request(method, url).andReturn().body().peek().jsonPath().
//    return response;
//    }
//    }
}

