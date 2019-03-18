package com.iqOption.services.rest.login;

import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.iqOption.util.RestConst.LoginURI.LOGIN_SERVICE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.text.MatchesPattern.matchesPattern;


public class PositiveLoginTest extends LoginTestInit {

    @Test(description = "Test description: Positive login scenario by REST with obligatory params")
    @Story("Using correct email/password of registered user in login request")
    public void successLogin() {
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(clientRestDataGenerator.getValidLoginParams())
                .post(LOGIN_SERVICE);
        response
                .then()
                .statusCode(200)
                .body("data.ssid", matchesPattern("^[a-f0-9]{32}$"));
    }
}
