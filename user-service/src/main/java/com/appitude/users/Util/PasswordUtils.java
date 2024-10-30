package com.appitude.users.Util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

@Slf4j
public class PasswordUtils {

    public static String getHashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            log.error("Error while hashing password", e);
            return null;
        }
    }
}
