package api;

import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.given;

public class RestClientHelper {
    static apiConfigProvider apiConfigProvider = new apiConfigProvider();

    static String apiUrl = apiConfigProvider.getProperty("apiUrl");
    static String userAccessToken = "Bearer "
            + apiConfigProvider.getProperty("userAccessToken");
    static String pageAccessToken;

    static   {
        Response response = given().headers("Content-Type", "application/json", "Authorization", userAccessToken)
                .when().get(apiUrl + "/2480108072278291?fields=access_token");
        Assert.assertEquals(response.statusCode(), 200);
        pageAccessToken = "Bearer " + response.getBody().jsonPath().get("access_token");
    }

    public Response post(String url) {
        Response response = given().headers("Content-Type", "application/json", "Authorization", pageAccessToken)
                .when().post(apiUrl + url);
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public Response get(String url) {
        Response response = given().headers("Content-Type", "application/json", "Authorization", pageAccessToken)
                .when().get(apiUrl + url);
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }

    public Response get(String url, Integer statusCode) {
        Response response = given().headers("Content-Type", "application/json", "Authorization", pageAccessToken)
                .when().get(apiUrl + url);
        Integer responseStatusCode = Integer.valueOf(response.statusCode());
        Assert.assertEquals(responseStatusCode, statusCode);
        return response;
    }

    public Response delete(String url) {
        Response response = given().headers("Content-Type", "application/json", "Authorization", pageAccessToken)
                .when().delete(apiUrl + url);
        Assert.assertEquals(response.statusCode(), 200);
        return response;
    }
}
