package com.iqOption.util;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.iqOption.client.Client;
import org.testng.Assert;

import java.util.*;

import static com.iqOption.util.RestConst.Headers.*;
import static com.iqOption.util.RestConst.ObligatoryRegisterParams;
import static com.iqOption.util.RestConst.ObligatoryRegisterParams.*;

//Util class for generating data
public class ClientRestDataGenerator {
    private Locale locale;
    private FakeValuesService fakeValuesService;
    private Faker faker;
    private Internet internet;

    //For testing different locales, constructor needs in Locale only
    public ClientRestDataGenerator(Locale locale) {
        this.locale = locale;
        fakeValuesService = new FakeValuesService(locale, new RandomService());
        faker = new Faker(locale);
        internet = faker.internet();
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(NAME.toString(), "cookie");
        headers.put(VALUE.toString(), "lang");
        headers.put(DATA.toString(), String.format("<lang=%s>", locale.toString()));
        return headers;
    }

    public Client getClientWithObligatoryFields() {
        String email = internet.emailAddress();
        String pswd = internet.password(7, 12, true);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String tz = String.format("%1$s/%2$s", faker.address().country(), faker.address().city());

        return new Client(email, pswd, firstName, lastName, tz);
    }

    public Map<String, String> getValidObligatoryRegisterParams() {
        Map<String, String> params = new HashMap<>();
        Client client = getClientWithObligatoryFields();

        params.put(EMAIL.toString(), client.getEmail());
        params.put(PASSWORD.toString(), client.getPassword());
        params.put(FIRST_NAME.toString(), client.getFirstName());
        params.put(LAST_NAME.toString(), client.getLastName());
        params.put(TZ.toString(), client.getTz());

        return params;
    }

    public Map<String, String> getNotValidObligatoryRegisterParams(ObligatoryRegisterParams... args) {
        Assert.assertFalse(args.length == 0, "Missing parameters for generation not valid request");
        Map<String, String> params = getValidObligatoryRegisterParams();
        ArrayList<ObligatoryRegisterParams> argsList = new ArrayList<>(Arrays.asList(args));
        argsList.forEach((e -> {
            if (e.equals(EMAIL)) params.put(e.toString(), faker.bothify("??##?????@mailcom"));
            if (e.equals(PASSWORD)) params.put(e.toString(), internet.password(4, 5));
            if (e.equals(FIRST_NAME)) params.put(e.toString(), "");
            if (e.equals(LAST_NAME)) params.put(e.toString(), "");
        }));
        return params;
    }

    public Map<String, String> getRegisterParamsAndReplace(ObligatoryRegisterParams param, String to) {
        Map<String, String> params = getValidObligatoryRegisterParams();
        params.put(param.toString(), to);
        return params;
    }

    //In a real environment, the test will access the database for specific emails/passwords taking into account depersonalization
    public Map<String, String> getValidLoginParams() {
        Map<String, String> params = new HashMap<>();
        params.put("email", "gabrielle.kuhic@yahoo.com");
        params.put("password", "vsKzgJ5dwJ");
        return params;
    }
}
