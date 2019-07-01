package api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BackendSpecification {
    PostHelper postHelper = new PostHelper();

    @BeforeClass
    protected void setUp() {
    }

    @AfterClass
    protected static void tearDown() {
    }
}
