import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class SOAP_XML_test {

    @Test
    public void add_XML() throws IOException {

    File file= new File("C:\\Users\\pspra\\IdeaProjects\\RESTassured\\SOAP_XML\\add.xml");
    if(file.exists()){
        System.out.println("  >>  File Exists");
    }
    FileInputStream fileInputStream = new FileInputStream(file);
    String requestBody = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8);

    baseURI="http://www.dneonline.com/";

    given().
            contentType("text/xml").
            accept(ContentType.XML).
            body(requestBody).
    when().
            post("/calculator.asmx").
    then().
            statusCode(200).
            log().all().
    and().
            body("//*:AddResult.text()",equalTo("7")).
    assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xml_validator.xsd"));

    }

    @Test
    public void subtract_XML() throws IOException {

        File file = new File("C:\\Users\\pspra\\IdeaProjects\\RESTassured\\SOAP_XML\\subtract.xml");
        if(file.exists()){
            System.out.println("  >>  File Exists");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, StandardCharsets.UTF_8);

        baseURI="http://www.dneonline.com/";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
        when().
                post("/calculator.asmx").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void multiply_XML() throws IOException {

        File file = new File("C:\\Users\\pspra\\IdeaProjects\\RESTassured\\SOAP_XML\\multiply.xml");
        if(file.exists()){
            System.out.println("  >>  File Exists");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream,StandardCharsets.UTF_8);

        baseURI="http://www.dneonline.com/";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
        when().
                post(" /calculator.asmx").
        then().
                statusCode(200).
                log().all();
    }

    @Test
    public void divide_XML() throws IOException {

        File file = new File("C:\\Users\\pspra\\IdeaProjects\\RESTassured\\SOAP_XML\\divide.xml");
        if(file.exists()){
            System.out.println("  >>  File Exists");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream,StandardCharsets.UTF_8);

        baseURI="http://www.dneonline.com/";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
        when().
                post(" /calculator.asmx").
        then().
                statusCode(200).
                log().all();
    }


}
