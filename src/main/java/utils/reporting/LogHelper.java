package utils.reporting;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.json.JSONObject;

public class LogHelper {
    public static void logRequest(ExtentTest test, String url, JSONObject body) {
        test.log(LogStatus.INFO, "Request URI: " + url);
        test.log(LogStatus.INFO, "Request Body: " + body.toString());
    }

    public static void logResponse(ExtentTest test, Response response) {
        test.log(LogStatus.INFO, "Response Status Code: " + response.getStatusCode());
        test.log(LogStatus.INFO, "Response Body: " + response.getBody().asString());
    }
}
