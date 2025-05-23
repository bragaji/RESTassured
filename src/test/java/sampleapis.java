import org.json.simple.JSONObject;
import org.testng.annotations.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;


public class sampleapis {

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

}
