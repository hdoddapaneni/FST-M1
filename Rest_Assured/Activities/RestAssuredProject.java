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

public class RestAssuredProject {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int keyId = 0;
    String SSHKey;

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization","token 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")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(2000L))
                .build();
    }

    @Test(priority = 1)
    public void postRequestTest() {
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIPuMU6W3VtupEl9S97pvLMQBsNAPCCepkfZXVpug1EbT");


        Response response = given().log().all().spec(requestSpec).body(reqBody).when().post();
        keyId = response.then().extract().path("id");
        response.then().spec(responseSpec).statusCode(201);

    }

    @Test(priority = 2)
    public void getRequestTest() {

        given().log().all().spec(requestSpec).pathParam("keyId", keyId).
                when().get("/{keyId}").
                then().spec(responseSpec).statusCode(200);
    }

    @Test(priority = 3)
    public void deleteRequestTest() {

        given().log().all().spec(requestSpec).pathParam("keyId", keyId).
                when().delete("/{keyId}").
                then().spec(responseSpec).statusCode(204);
    }


}
