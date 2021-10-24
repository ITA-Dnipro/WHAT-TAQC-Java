package api.base;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.testng.annotations.BeforeTest;

public class BaseTestApi {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "https://charliebackendapi.azurewebsites.net/api/v2";
        RestAssured.defaultParser = Parser.JSON;

    }

}
