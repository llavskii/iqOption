package com.iqOption.services.rest.register;

import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.iqOption.util.RestConst.RegisterURI.REGISTER_SERVICE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PositiveRegisterTest extends RegisterTestInit {

    @Test(description = "Test description: Positive scenario of registration by REST with obligatory params")
    @Story("All correct paramaters of request for registration")
    public void successRegistration() {
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(clientRestDataGenerator.getValidObligatoryRegisterParams())
                .post(REGISTER_SERVICE);

        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(true))
        ;
    }

}
