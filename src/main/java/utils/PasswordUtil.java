package utils;

public class PasswordUtil {

    public static String hashPassword(String password) {
        return HashUtil.applySHA256(password);
    }
}