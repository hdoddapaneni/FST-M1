import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Activity1 {
    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority=1)
    public void addNewPet() {
        // Create JSON request
//        String reqBody = "{"
//                + "\"id\": 77232,"
//                + "\"name\": \"Riley\","
//                + " \"status\": \"alive\""
//                + "}";
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("id","11111");
        reqBody.put("name","Ishi");
        reqBody.put("status","available");

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody) // Add request body
                        .when().post(ROOT_URI); // Send POST request

        System.out.println(response);

        // Assertion
        response.then().body("id", equalTo(11111));
        response.then().body("name", equalTo("Ishi"));
        response.then().body("status", equalTo("available"));
    }

    @Test(priority=2)
    public void getPetInfo() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "11111") // Set path parameter
                        .get(ROOT_URI + "/{petId}"); // Send GET request

        // Assertion
        response.then().body("id", equalTo(11111));
        response.then().body("name", equalTo("Ishi"));
        response.then().body("status", equalTo("available"));
    }

    @Test(priority=3)
    public void deletePet() {
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "11111") // Set path parameter
                        .delete(ROOT_URI + "/{petId}"); // Send DELETE request

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("11111"));
    }
}
