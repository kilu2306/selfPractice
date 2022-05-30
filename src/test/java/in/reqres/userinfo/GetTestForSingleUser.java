package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTestForSingleUser extends TestBase {
    @Test
    public void getSingleUserRecord(){
        Response response = given()
             .queryParam("page",2)
                .when()
                .get("/users/2");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
