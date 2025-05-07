package gr.dimitriskaitantzidis.schoolspringapp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashChecker {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.matches("1234", "$2a$10$T0JT/l5iDgjp68BU3b89ZOPP9pDAzT5DBmUBKz8UD.uy2EUqe4ToS"));
    }
}
