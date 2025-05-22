import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    void test1(){

        Response response = given().header("x-api-key", "reqres-free-v1").when() .get("https://reqres.in/api/users?page=2");
        System.out.println("Response :"+response.asString());
        System.out.println("Status Code :"+response.getStatusCode());
        System.out.println("Body :"+response.getBody().asString());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

    @Test
    void test2(){

        given().get("https://reqres.in/api/users?page=2").then().statusCode(200);

    }

}
