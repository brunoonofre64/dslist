package io.brunoonofre64.utils;

public interface ConstantesIntegrationTest {

    String TEXT_DEFAULT = "TEXT_DEFAULT";
    String TEXT_DEFAULT_2 = "TEXT_DEFAULT_2";
    Integer INTEGER_DEFAULT = 1;
    Integer INTEGER_DEFAULT_2 = 2;
    Double DOUBLE_DEFAULT = 1.0;
    Double DOUBLE_DEFAULT_2 = 2.0;
    String SLASH = "/";
    String GAMES = "games";
    String NONEXISTENT_ID = "123";
    String INVALID_ID = "INVALID_ID";
    String ID_DEFAULT = "ID_DEFAULT";
    String EMAIL = "admin@admin";
    String PASSWORD = "admin";
    String PASSWORD_2 = "admin_2";
    String ROLE_ADMIN = "ROLE_ADMIN";
    String USER_EMAIL = "user@user";
    String GUEST_EMAIL = "guest@guest";
    String EMAIL_PARAM = "?email=";
    String USER = "USER";
    String ADMIN = "ADMIN";

    interface WEB_METHOD_TEST {
        String V1_GAME = "/game";
        String V1_LIST = "/list";
        String V1_USER = "/user";
        String V1_ROLE = "/role";
    }
}
