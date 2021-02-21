package restAssured;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserApiTest {

//    @After
//    public void afterAll() {
//        BaseUser userHelper = new BaseUser();
//        userHelper.deleteUser("AnnaTest");
//
//    }

    @Test
    public void createUser() {
        BaseUser userHelper = new BaseUser();
        Response response;

        Map<String, Object> user = new HashMap<>();
        user.put("username", "AnnaTest");
        user.put("email", "test@gmail.com");

        response = userHelper.createNewUser(user);

        response
                .then()
                .spec(userHelper.responseSpecSpecification)
                .log().all();

    }

    @Test
    public void createUserWithInvalideData() {
        BaseUser userHelper = new BaseUser();
        Response response;

        Map<String, Object> user = new HashMap<>();
        user.put("username", "InvalideUser");
        user.put("userStatus", "14545454545487874569852152");

        response = userHelper.createNewUser(user);

        response
                .then()
                .log().all()
                .statusCode(500)
                .body("type", equalTo("unknown"))
                .body("message", equalTo("something bad happened"));
    }


    @Test
    public void getUser() {

        BaseUser userHelper = new BaseUser();
        Response response = userHelper.getUser("AnnaTest");

        response
                .then()
                .spec(userHelper.responseSpecSpecification)
                .log().all()
                .body("username", equalTo("AnnaTest"))
                .body("email", equalTo("test@gmail.com"));


    }


    @Test
    public void getNonExistentUser() {
        BaseUser userHelper = new BaseUser();
        Response response = userHelper.getUser("NonExisten");

        response
                .then()
                .log().all()
                .statusCode(404)
                .body("type", equalTo("error"))
                .body("message", comparesEqualTo("User not found"));
    }

}
