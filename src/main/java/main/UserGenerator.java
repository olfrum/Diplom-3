package main;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import pojo.User;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static main.Constance.*;

import java.util.Locale;

public class UserGenerator {

    @Step("Generate new user")
    public static User getNewUser(){
        Faker faker = new Faker(new Locale("en"));
        return new User (
                faker.internet().emailAddress(),
                faker.internet().password(7, 8),
                faker.name().firstName());
    }

    @Step("Delete created user")
    public static void deleteUserRequest(String email, String password) {
        String body = String.format("{%n\"email\": \"%s\",%n\"password\": \"%s\"%n}", email, password);
        String requestBody = given().header("Content-type", JSON).and().body(body)
                .when().post(BASE_URI + LOGIN_API).getBody().asString();
        JsonPath jp = new JsonPath(requestBody);
        String token = jp.getString("accessToken").split(" ")[1];
        given().auth().oauth2(token).header("Content-type", JSON).when()
                .delete(BASE_URI + DELETE_USER_API).then().assertThat().statusCode(202);
    }
}
