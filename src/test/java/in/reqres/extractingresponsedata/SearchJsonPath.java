package in.reqres.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class SearchJsonPath {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
        response = given()
                .queryParam("page", 2)
                .when()
                .get("/users")
                .then().statusCode(200);

    }

    @Test
    //1] to verify page=2"
    public void verifyPage() {
        int pageNum = response.extract().path("page");
        System.out.println("page number is :" + pageNum);
    }
     //"2] to verify per_page = 6
    @Test
    public void perpageRecord(){
        int pageNum = response.extract().path("per_page");
        System.out.println("per_page record is :" + pageNum);
    }
    //3] to verify data[1].id = 8"
    @Test
    public  void ObjectId(){
        int id=response.extract().path("data[1].id");
        System.out.println("data[1].id = :" + id);

    }
    //4] to veryfy4.data[3].first_name = Byron
    @Test
    public void ObjectFirstName(){
       String name =response.extract().path("data[3].first_name ");
        System.out.println("data[3].first_name  :=" + name);
    }
    //5] to veryfy5.list of data = 6"
    @Test
    public void listOfData(){
        int num =response.extract().path("size()");
        System.out.println("number of list data  :=" + num);
    }
    //6] to veryfy data[5].avatar"
    @Test
    public void verifyAvatar(){
       String link =response.extract().path("data[5].avatar");
        System.out.println("linkof data[5].avatar :=" + link);
    }
    //7. support.url :https://reqres.in/#support-heading",
    @Test
    public void verifyUrl(){
        String url = response.extract().path("support.url");
        System.out.println("link of URL:= "+url);
    }
    //8. support.txt  :To keep ReqRes free, contributions towards server costs are appreciated!
    @Test
    public void verifyText(){
        String text = response.extract().path("support.text");
        System.out.println("link of URL:= "+ text);
    }

}
