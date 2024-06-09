package data.restful.user_creation;


import entity.response.user.UserCreationResponse;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.restful_helper.ApiHelper;

public class UserCreationTest {
    @Test
    public void createUserAssertion() {
        JSONObject body = new JSONObject();
        body.put("name", "mohamed");
        body.put("job", "QC");
        Response response = ApiHelper.post("https://reqres.in/api/users", body);

        // Deserialize JSON to java object if needed in more future assertion
        UserCreationResponse user = response.body().as(UserCreationResponse.class);

        // Validate on status code
        Assert.assertEquals(response.getStatusCode(), 201);

        // Validate response body contains id, name, and job
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("name"));
        Assert.assertTrue(responseBody.contains("job"));
        Assert.assertTrue(responseBody.contains("id"));

        // validate that id not null and have value
        Assert.assertNotNull(response.body().jsonPath().get("id"));

        // validate that name and job from response body equals data sent
        Assert.assertEquals(response.body().jsonPath().get("name"),"mohamed");
        Assert.assertEquals(response.body().jsonPath().get("job"),"QC");




    }
}
