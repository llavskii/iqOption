package com.iqOption.services.websocket.authorization;

import com.iqOption.util.TestListener;
import com.iqOption.util.WebsocketParamsDataGen;
import io.qameta.allure.Story;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Listeners({TestListener.class})
public class PositiveAuthorizationTest {

    public static final String WEBSOCKET_URI = "wss://iqoption.com/echo/websocket";
    public static final OkHttpClient client = new OkHttpClient();

    @Test(description = "Test description: Positive authorization scenario by websocket")
    @Story("Using correct email/password to get ssid and authorization")
    public void successAuthorizationBySsid() throws IOException {
        //For testing authorization by websocket, need to get ssid
        String ssid = WebsocketParamsDataGen.getSsidByRestLogin();
        String profileByRest = WebsocketParamsDataGen.getProfileByRest(ssid);

        Request request = new Request.Builder()
                .url(WEBSOCKET_URI)
                .addHeader("Upgrade", "websocket")
                .addHeader("Connection", "Upgrade")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assertThat(response.code(), equalTo(200));
    }
}
