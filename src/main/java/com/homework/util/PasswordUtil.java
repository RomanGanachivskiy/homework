package com.homework.util;

public interface PasswordUtil {
    boolean verify(String rawPassword, String encodedPassword);

    String encode (String password);
}