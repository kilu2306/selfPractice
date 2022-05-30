package in.reqres.userinfo;

import in.reqres.model.TokenPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTestForLogInToken extends TestBase {
    @Test
    public void getToken() {
        TokenPojo tokenPojo = new TokenPojo();
        tokenPojo.setEmail("eve.holt@reqres.in");
        tokenPojo.setPassword("cityslicka");

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body(tokenPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
