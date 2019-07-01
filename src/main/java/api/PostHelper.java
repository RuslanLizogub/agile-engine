package api;

import io.restassured.response.Response;
import org.testng.Assert;

import java.util.UUID;

public class PostHelper {
    private RestClientHelper restClient = new RestClientHelper();
    private String postId;
    private String message;

    public void createNewPost() {
        message = UUID.randomUUID().toString();
        System.out.println("message = " + message);
        String url = "2480108072278291/feed?message=" + message;
        Response response = restClient.post(url);
        postId = response.getBody().jsonPath().get("id");
        System.out.println("postId = " + postId);
    }

    public void readNewPost() {
        Response response = restClient.get(postId);
        Assert.assertEquals(response.getBody().jsonPath().get("id"), postId);
        Assert.assertEquals(response.getBody().jsonPath().get("message"), message);
    }

    public void updateNewPost() {
        // Update new post
        String messageUpdate = UUID.randomUUID().toString();
        System.out.println("messageUpdate = " + message);
        restClient.post(postId + "/?message=" + messageUpdate);

        // Check new message
        Response response = restClient.get(postId);
        Assert.assertEquals(response.getBody().jsonPath().get("message"), messageUpdate);
    }

    public void deleteNewPost() {
        Response response = restClient.delete(postId);
        Boolean deleteStatus = response.getBody().jsonPath().get("success");
        Assert.assertTrue(deleteStatus);
    }

    public void checkThatPostWasRemoved() {
        restClient.get(postId, 400);
    }
}
