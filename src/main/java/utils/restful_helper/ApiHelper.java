package utils.restful_helper;


import com.relevantcodes.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class ApiHelper {
    static ExtentTest test;

    public static Response post(String url, JSONObject body) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when().log().all()
                .post(url)
                .then().log().all()
                .extract().response();

    }

    public static Response get(String url) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get(url)
                .then().log().all()
                .assertThat().statusCode(200).extract().response();

    }

    public static Response put(String url, JSONObject body) {

        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(body.toString())
                .when().log().all()
                .put(url)
                .then().log().all()
                .assertThat().statusCode(200).extract().response();

    }

    public static Response delete(String url) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .delete(url)
                .then().log().all()
                .assertThat().statusCode(204).extract().response();

    }
}
