package com.iqOption.register;

import com.iqOption.TestInit;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.iqOption.util.RestConst.REGISTER_URI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

//@Listeners({TestListener.class})
public class PositiveScenario extends TestInit {

    @Test(description = "Test description: Positive scenario of registration by REST with obligatory params")
    @Story("All correct paramaters of request for registration")
    public void successRegistration() {
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(clientRestDataGenerator.getValidObligatoryRegisterParams())
                .post(REGISTER_URI);

        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(true))
        ;
    }

}
