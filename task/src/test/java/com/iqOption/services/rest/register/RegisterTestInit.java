package com.iqOption.services.rest.register;

import com.iqOption.services.rest.AbstractRestTest;
import com.iqOption.util.RestConst;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class RegisterTestInit extends AbstractRestTest {

    @Override
    @BeforeTest(alwaysRun = true)
    public void init() {
        RestAssured.baseURI = RestConst.RegisterURI.REGISTER_BASE_URI;
    }


}
