package api;
import org.testng.annotations.Test;

public class CRUDfacebookPostAPI extends BackendSpecification {
    @Test
    public void facebookCRUD() {
        postHelper.createNewPost();
        postHelper.readNewPost();
        postHelper.updateNewPost();
        postHelper.deleteNewPost();
        postHelper.checkThatPostWasRemoved();
    }
}
