package com.iqOption.util;

public class RestConst {
    public static class RegisterURI {
        public static final String REGISTER_BASE_URI = "https://iqoption.com/api";
        public static final String REGISTER_SERVICE = "/register";
    }

    public static class GetProfileURI {
        public static final String GET_PROFILE_BASE_URI = "https://iqoption.com/api";
        public static final String GET_PROFILE_SERVICE = "/getprofile";
    }

    public static class LoginURI {
        public static final String LOGIN_BASE_URI = "https://auth.iqoption.com/api";
        public static final String LOGIN_SERVICE = "/v1.0/login";
    }

    public enum Headers {
        NAME("name"),
        VALUE("value"),
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
