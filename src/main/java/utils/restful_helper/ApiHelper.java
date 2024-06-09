package utils.restful_helper;


import io.restassured.RestAssured;
import io.restassured.authentication.OAuthSignature;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

public class ApiHelper {

    public static Response post(String url, JSONObject body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when().log().all()
                .post(url)
                .then().log().all()
                .extract().response();

    }

}
