package Example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class SpecificationTest {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int petId = 0;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type", "application/json")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(2000L))
                .build();
    }

    @Test(priority = 1)
    public void postRequestTest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", "11112");
        reqBody.put("name", "Ishi");
        reqBody.put("status", "available");

        Response response = given().spec(requestSpec).body(reqBody).when().post();
        petId = response.then().extract().path("id");
        response.then().spec(responseSpec).body("name", equalTo("Ishi"));

    }

    @Test(priority = 2)
    public void getRequestTest() {

        given().spec(requestSpec).pathParam("petId", petId).
                when().get("/{petId}").
                then().spec(responseSpec).body("name", equalTo("Ishi"));
    }

    @Test(priority = 3)
    public void deleteRequestTest() {

        given().spec(requestSpec).pathParam("petId", petId).
                when().delete("/{petId}").
                then().spec(responseSpec).body("message", equalTo(+petId));
    }


}


