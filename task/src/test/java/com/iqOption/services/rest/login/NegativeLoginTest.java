package com.iqOption.services.rest.login;

import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.iqOption.util.RestConst.LoginURI.LOGIN_SERVICE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class NegativeLoginTest extends LoginTestInit {

    @Test(description = "Test description: Negative login scenario by REST with obligatory params")
    @Story("Using incorrect email of registered user in login request")
    public void incorrectEmail() {
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(clientRestDataGenerator.getNotValidLoginEmailInParams())
                .post(LOGIN_SERVICE);
        response
                .then()
                .statusCode(400)
                .body("errors[0].title", equalTo("Invalid email"));
    }

    @Test(description = "Test description: Negative login scenario by REST with obligatory params")
    @Story("Using incorrect password of registered user in login request")
    public void incorrectPassword() {
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(clientRestDataGenerator.getNotValidLoginPasswordInParams())
                .post(LOGIN_SERVICE);
        response
                .then()
                .statusCode(403)
                .body("errors[0].title", equalTo("Invalid credentials"));
    }
}
