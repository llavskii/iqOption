package com.iqOption.services.rest;

import com.iqOption.util.ClientRestDataGenerator;
import com.iqOption.util.TestListener;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;

import java.util.Locale;

@Listeners({TestListener.class})
public abstract class AbstractRestTest {
    protected ClientRestDataGenerator clientRestDataGenerator = new ClientRestDataGenerator(new Locale("en-US"));
    protected Response response;

    public abstract void init();
}
