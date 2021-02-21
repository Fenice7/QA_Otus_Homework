package restAssured;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class BaseUser {

    //    Map<String, Object> user = new HashMap<>();
    Map<String, Object> user;

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private static final String BASE_PATH = "/user";

    RequestSpecification requestSpecification;

    ResponseSpecification responseSpecSpecification = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(5000L))
            .build();

    public BaseUser
            () {
        requestSpecification = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }

    public Response createNewUser(Map user) {
        return given()
                .spec(requestSpecification)
                .with()
                .body(user)
                .when()
                .post(BASE_PATH);
    }

    public Response getUser(String username) {
        return given(requestSpecification)
                .when()
                .get(BASE_PATH + "/" + username);
    }

    public Response deleteUser(String username) {
        return given(requestSpecification)
                .when()
                .delete(BASE_PATH + "/" + username);
    }

}
