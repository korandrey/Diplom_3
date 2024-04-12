package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import site.nomoreparties.stellarburgers.utils.Rest;

import static io.restassured.RestAssured.given;

public class UserActions extends Rest {
    private static final String CREATE_USER_PATH = "/api/auth/register";
    private static final String CHANGE_USER_PATH = "/api/auth/user";

    @Step("Создать пользователя")
    public ValidatableResponse create(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(CREATE_USER_PATH)
                .then();
    }

    @Step("Удалить пользователя")
    public ValidatableResponse delete(String accessToken) {
        return given()
                .spec(getSpec())
                .auth().oauth2(accessToken)
                .when()
                .delete(CHANGE_USER_PATH).then();
    }
}
