package com.devsione.dreamwell.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {

    public static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String hashPass(String password){
        return passwordEncoder.encode(password);
    }

    public static boolean verifyPass(String plainPass, String hashPass){
        return passwordEncoder.matches(plainPass, hashPass);
    }
}
