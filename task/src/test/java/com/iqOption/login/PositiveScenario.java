package com.iqOption.login;

import com.iqOption.TestInit;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.iqOption.util.RestConst.LOGIN_URI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PositiveScenario extends TestInit {

    @Test(description = "Test description: Positive login scenario by REST with obligatory params")
    @Story("Using email/password of registered user in login request")
    public void successLogin() {
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(clientRestDataGenerator.getValidLoginParams())
                .post(LOGIN_URI);
        System.out.println(response.getHeaders().asList());
        System.out.println(response.getBody().asString());
        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(true))
        ;
    }
}
