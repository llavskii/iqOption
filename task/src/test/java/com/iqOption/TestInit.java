package com.iqOption;

import com.iqOption.util.ClientRestDataGenerator;
import com.iqOption.util.TestListener;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.util.Locale;

import static com.iqOption.util.RestConst.BASE_URI;

@Listeners({TestListener.class})
public class TestInit {

    protected ClientRestDataGenerator clientRestDataGenerator;
    protected Response response;

    @BeforeSuite(alwaysRun = true)
    public void init() {
        RestAssured.baseURI = BASE_URI;
    }

    @BeforeTest(alwaysRun = true)
    public void initializeClientRestDataGenerator() {
        clientRestDataGenerator = new ClientRestDataGenerator(new Locale("en-US"));
    }


}
