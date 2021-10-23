package api.base.request;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;

public class BaseRequests {

    protected RequestSpecification request;
    Map<String, String> headers;
    protected static String BASE_API_URL = "https://charliebackendapi.azurewebsites.net/api/v2";

    public BaseRequests() {
        request = RestAssured.given();
        RestAssured.defaultParser = Parser.JSON;
        headers = new HashMap<>();
        headers.put("Content-type", "application/json");
    }

    public void setHeaders(Map<String, String> headers){
        this.headers = headers;
    }

    public Response sendPost(String url, String body){

        return request.accept("application/json")
                .contentType(ContentType.JSON)
                .headers(headers)
                .and().body(body)
                .when().post(BASE_API_URL + url)
                .then().extract()
                .response();
    }

    public Response sendGet(String url){
        return request.
                headers(headers)
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_API_URL + url)
                .then()
                .extract()
                .response();
    }
}
