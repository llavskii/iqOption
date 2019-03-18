package com.iqOption.util;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.Locale;
import java.util.Map;

import static com.iqOption.util.RestConst.GetProfileURI.GET_PROFILE_BASE_URI;
import static com.iqOption.util.RestConst.GetProfileURI.GET_PROFILE_SERVICE;
import static com.iqOption.util.RestConst.LoginURI.LOGIN_SERVICE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.text.MatchesPattern.matchesPattern;

public class WebsocketParamsDataGen {

    public static String getSsidByRestLogin() {
        RestAssured.baseURI = RestConst.LoginURI.LOGIN_BASE_URI;
        ClientRestDataGenerator clientRestDataGenerator = new ClientRestDataGenerator(new Locale("en-US"));
        Response response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(clientRestDataGenerator.getValidLoginParams())
                .post(LOGIN_SERVICE);
        response
                .then()
                .statusCode(200)
                .body("data.ssid", matchesPattern("^[a-f0-9]{32}$"));

        JsonPath jsonPath = response.then().extract().body().jsonPath();
        return jsonPath.getString("data.ssid");
    }

    public static String getProfileByRest(String ssid) {
        RestAssured.baseURI = GET_PROFILE_BASE_URI;
        ClientRestDataGenerator clientRestDataGenerator = new ClientRestDataGenerator(new Locale("en-US"));

        Map<String, String> validGetProfileParams = clientRestDataGenerator.getValidGetProfileParams(ssid);

        Response response = given()
                .headers(clientRestDataGenerator.getHeaders())
                .params(validGetProfileParams)
                .get(GET_PROFILE_SERVICE);
        response
                .then()
                .statusCode(200)
                .body("isSuccessful", equalTo(true));

        JsonPath jsonPath = response.then().extract().body().jsonPath();
        return jsonPath.getString("result");
    }
}
