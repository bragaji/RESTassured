import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.*;

public class SOAP_XML_test {

    @Test
    public void SOAP_XML() throws IOException {

    File file= new File("C:\\Users\\pspra\\IdeaProjects\\RESTassured\\SOAP_XML\\XML.xml");
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
    then().statusCode(200).
            log().all();

    }


}
