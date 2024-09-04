package restful.user;


import entity.response.user.UserCreationResponse;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.restful_helper.ApiHelper;

public class UserTest {
    @Test(priority = 1)
    public void createUsers() {
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
        Assert.assertEquals(response.body().jsonPath().get("name"), "mohamed");
        Assert.assertEquals(response.body().jsonPath().get("job"), "QC");


    }

    @Test(priority = 2)
    public void getUsers() {

        Response response = ApiHelper.get("https://reqres.in/api/users");

        // Validate on status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Validate response body contains id, name, and job
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("name"));
        Assert.assertTrue(responseBody.contains("email"));
        Assert.assertTrue(responseBody.contains("id"));

        // validate that first element attributes in array is not null and have value
        Assert.assertNotNull(response.body().jsonPath().get("data[0].id"));
        Assert.assertNotNull(response.body().jsonPath().get("data[0].email"));
        Assert.assertNotNull(response.body().jsonPath().get("data[0].first_name"));
        Assert.assertNotNull(response.body().jsonPath().get("data[0].last_name"));
        Assert.assertNotNull(response.body().jsonPath().get("data[0].avatar"));


    }

    @Test(priority = 3)
    public void editUsers() {
        JSONObject body = new JSONObject();
        body.put("name", "mohamed");
        body.put("job", "QC");
        Response response = ApiHelper.put("https://reqres.in/api/users/2", body);

        // Validate on status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Validate response body contains id, name, and job
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("name"));
        Assert.assertTrue(responseBody.contains("job"));

        // validate that name and job from response body equals data sent
        Assert.assertEquals(response.body().jsonPath().get("name"), "mohamed");
        Assert.assertEquals(response.body().jsonPath().get("job"), "QC");


    }

    @Test(priority = 4)
    public void deleteUsers() {

        Response response = ApiHelper.delete("https://reqres.in/api/users/3");

        // Validate on status code
        Assert.assertEquals(response.getStatusCode(), 204);


    }

}
