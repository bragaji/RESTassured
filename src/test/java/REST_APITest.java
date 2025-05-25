import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;


public class REST_APITest {

    @Test
    public void testGet(){

        baseURI="https://reqres.in/api";

        given().
          get("/users?page=2").
        then().
          statusCode(200).
          body("data[4].first_name",equalTo("George"));

    }

    @Test
    public void testPost(){


        JSONObject request=new JSONObject();
        request.put("name","Prashant");
        request.put("job","QA");

        System.out.println(request.toJSONString());

        baseURI="https://reqres.in/api";

        given().
            header("x-api-key", "reqres-free-v1").
            body(request.toJSONString()).
        when().
            post("/users").
        then().
            statusCode(201);


    }

    @Test
    public void testPut(){

        baseURI="https://reqres.in/api";

        JSONObject request = new JSONObject();
        request.put("name","Braga");
        request.put("job","PM");

        given().header("x-api-key", "reqres-free-v1").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().put("/users/2").then().statusCode(200).log().all();

    }

    @Test
    public void testPatch(){
        baseURI="https://reqres.in/api";

        JSONObject request = new JSONObject();
        request.put("name","Gautam");
        request.put("job","QA2");

        given().header("x-api-key", "reqres-free-v1").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().patch("/users/2").then().statusCode(200).log().all();


    }

    @Test
    public void testDelete(){
        baseURI="https://reqres.in/api";

        given().header("x-api-key", "reqres-free-v1").delete("/api/users/2").
                then().statusCode(204).log().all();
    }

}
