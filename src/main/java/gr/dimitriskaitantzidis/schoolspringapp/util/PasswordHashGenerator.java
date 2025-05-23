package gr.dimitriskaitantzidis.schoolspringapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("1234"));
    }

    public static String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}