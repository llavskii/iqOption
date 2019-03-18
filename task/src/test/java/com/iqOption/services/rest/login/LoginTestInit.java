package com.iqOption.services.rest.login;

import com.iqOption.services.rest.AbstractRestTest;
import com.iqOption.util.RestConst;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class LoginTestInit extends AbstractRestTest {

    @Override
    @BeforeTest(alwaysRun = true)
    public void init() {
        RestAssured.baseURI = RestConst.LoginURI.LOGIN_BASE_URI;
    }


}
