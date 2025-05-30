import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class xml_schema_validation {


    @Test
    public void validate_xml_schema() throws Exception {

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
                    body("//*:AddResult.text()",equalTo("7"));
        }



}
