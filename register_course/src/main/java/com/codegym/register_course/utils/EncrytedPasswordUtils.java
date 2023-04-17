package com.codegym.register_course.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password1 = "khai123";
        String password2 = "dat123";
        String password3 = "anh123";
        String encrytedPassword1 = encrytePassword(password1);
        String encrytedPassword2 = encrytePassword(password2);
        String encrytedPassword3 = encrytePassword(password3);

        System.out.println("Encryted Password: " + encrytedPassword1);
        System.out.println("Encryted Password: " + encrytedPassword2);
        System.out.println("Encryted Password: " + encrytedPassword3);
    }

}
