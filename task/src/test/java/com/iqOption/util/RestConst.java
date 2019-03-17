package com.iqOption.util;

public class RestConst {
    public static final String BASE_URI = "https://iqoption.com";
    public static final String REGISTER_URI = "/api/register";
    public static final String LOGIN_URI = "/api/login/v2";

    public enum Headers {
        NAME("name"),
        VALUE("lang"),
        DATA("data");
        private final String header;

        private Headers(String s) {
            header = s;
        }

        public String toString() {
            return this.header;
        }
    }

    public enum ObligatoryRegisterParams {
        EMAIL("email"),
        PASSWORD("password"),
        FIRST_NAME("first_name"),
        LAST_NAME("last_name"),
        TZ("tz");

        private final String param;

        public String toString() {
            return this.param;
        }

        private ObligatoryRegisterParams(String s) {
            param = s;
        }
    }

}
