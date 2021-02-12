package restAssured;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserApiTest {

    //Создать и отправить запрос с максимальным количеством данных
    //Пользователь создан без ошибок
    @Test
    public void createUser() {
        BaseUser userHelper = new BaseUser();
        Response response;

        Map<String, Object> user = new HashMap<>();
        user.put("username", "BBowers");
        user.put("firstName", "Benjamin");
        user.put("lastName", "Bowers");
        user.put("email", "bbmailmen@gmail.com");
        user.put("password", "skilled-voguish");
        user.put("phone", "+7-000-000-00-00");

        response = userHelper.createNewUser(user);

        response
                .then()
                .spec(userHelper.responseSpecSpecification)
                .log().all()
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"));


    }

    //Создать и отправить запрос с невалидными данными
    //Пользователь не найден, получаем сообщение об ошибке
    @Test
    public void createUserWithInvalideData() {
        BaseUser userHelper = new BaseUser();
        Response response;

        Map<String, Object> user = new HashMap<>();
        user.put("username", "InvalideUser");
        user.put("userStatus", "14545454545487874569852152L");

        response = userHelper.createNewUser(user);

        response
                .then()
                .log().all()
                .statusCode(500)
                .body("type", equalTo("unknown"))
                .body("message", equalTo("something bad happened"));
    }

    //Создать и отправить запрос, отправить в него username существуещего пользователя
    //Пользователь найден, в ответе приходит подробная информация о пользователе
    @Test
    public void getUser() {

        BaseUser userHelper = new BaseUser();
        Response response = userHelper.getUser("BBowers");

        response
                .then()
                .spec(userHelper.responseSpecSpecification)
                .log().all()
                .body("username", equalTo("BBowers"))
                .body("email", equalTo("bbmailmen@gmail.com"));


    }

    //Создать и отправить запрос с невалидными данными
    //Пользователь не найден, получаем сообщение об ошибке
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
