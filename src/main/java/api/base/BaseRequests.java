package api.base;

import api.entities.RegisteredUser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.User;

import java.util.HashMap;
import java.util.Map;

import static api.APIConstants.AccountEndpoints.AUTH_ENDPOINT;
import static api.APIConstants.BASE_LINK;
import static api.APIConstants.Headers.APPLICATION_JSON;
import static api.APIConstants.Headers.CONTENT_TYPE;

public class BaseRequests {

    protected RequestSpecification request;
    Map<String, String> headers;
    protected RegisteredUser registeredUser;

    public BaseRequests() {
        request = RestAssured.given();
        headers = new HashMap<>();
        headers.put(CONTENT_TYPE, APPLICATION_JSON);
    }

    public RegisteredUser logIn(User user) {
        return sendPost(AUTH_ENDPOINT, user.toString())
                .body()
                .as(RegisteredUser.class);
    }

    public Response sendPost(String url, String body) {
        return request.accept(APPLICATION_JSON)
                .contentType(ContentType.JSON)
                .headers(headers)
                .and()
                .body(body)
                .when()
                .post(BASE_LINK + url)
                .then()
                .extract()
                .response();
    }

    public Response sendGet(String url) {
        return request.
                headers(headers)
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_LINK + url)
                .then()
                .extract()
                .response();

    }

    public Response sendGet(String url, String tail, Integer id) {
        return request.
                headers(headers)
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_LINK + url + id.toString() + tail)
                .then()
                .extract()
                .response();
    }

    public Response sendPut(String url, Integer id, String body) {
        return request.accept(APPLICATION_JSON)
                .contentType(ContentType.JSON)
                .headers(headers)
                .and()
                .body(body)
                .when()
                .put(BASE_LINK + url + id.toString())
                .then()
                .extract()
                .response();
    }

    public Response sendPatch(String url, Integer id, String body) {
        return request.accept(APPLICATION_JSON)
                .contentType(ContentType.JSON)
                .headers(headers)
                .and()
                .body(body)
                .when()
                .patch(BASE_LINK + url + id.toString())
                .then()
                .extract()
                .response();
    }

    public Response sendDelete(String url, Integer id) {
        return request.accept(APPLICATION_JSON)
                .contentType(ContentType.JSON)
                .headers(headers)
                .when()
                .delete(BASE_LINK + url + id.toString())
                .then()
                .extract()
                .response();
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }
}