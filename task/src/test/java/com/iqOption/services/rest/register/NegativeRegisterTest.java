package com.iqOption.services.rest.register;

import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.Map;

import static com.iqOption.util.RestConst.ObligatoryRegisterParams.*;
import static com.iqOption.util.RestConst.RegisterURI.REGISTER_SERVICE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class NegativeRegisterTest extends RegisterTestInit {
    @Test(description = "Test description: Negative scenario of registration by REST with obligatory params")
    @Story("Using email of registered user in request for registration")
    public void existEmail() {
        //In a real environment, the test will access the database for specific emails taking into account depersonalization
        Map<String, String> params = clientRestDataGenerator.getRegisterParamsAndReplace(EMAIL, "llavskii@ya.ru");
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(params)
                .post(REGISTER_SERVICE);
        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(false))
                .body("message[0]", equalTo("You have already registered"))
        ;
    }

    @Test(description = "Test description: Negative scenario of registration by REST with obligatory params")
    @Story("Using invalid email format in request for registration")
    public void notValidEmail() {
        Map<String, String> params = clientRestDataGenerator.getNotValidObligatoryRegisterParams(EMAIL);
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(params)
                .post(REGISTER_SERVICE);
        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(false))
                .body("message.email[0]", equalTo("E-mail is not valid"))
        ;
    }

    @Test(description = "Test description: Negative scenario of registration by REST with obligatory params")
    @Story("Using empty String for first name in request for registration")
    public void missingFirstName() {
        Map<String, String> params = clientRestDataGenerator.getRegisterParamsAndReplace(FIRST_NAME, "");
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(params)
                .post(REGISTER_SERVICE);
        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(false))
                .body("message.first_name[0]", equalTo("First name is required"))
        ;
    }

    @Test(description = "Test description: Negative scenario of registration by REST with obligatory params")
    @Story("Using invalid password in request for registration")
    public void notValidPassword() {
        Map<String, String> params = clientRestDataGenerator.getNotValidObligatoryRegisterParams(PASSWORD);
        response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(params)
                .post(REGISTER_SERVICE);
        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(false))
                .body("message.password[0]", equalTo("Invalid password length"))
        ;
    }
}
