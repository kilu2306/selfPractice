package in.reqres.userinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetTestForList extends TestBase {
    @Test
    public void getListOfUser(){
        Response response=given().log().all()
                .queryParam("page",2)
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
