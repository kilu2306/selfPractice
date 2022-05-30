package in.reqres.userinfo;

import in.reqres.model.UserPoJo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostTestForCreatUser extends TestBase {


    @Test
    public void CreatUserRecord() {
        UserPoJo userPoJo = new UserPoJo();
        userPoJo.setName("morpheus");
        userPoJo.setJob("leader");
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .body(userPoJo)
                .when()
                .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();

    }


}
