import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class JSONSchemaValidator {

@Test
    public void testGet(){

    baseURI="https://reqres.in/api";

    given().
            header("x-api-key", "reqres-free-v1").
            get("/users?page=2").
    then().
            assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
            statusCode(200);



}

}
