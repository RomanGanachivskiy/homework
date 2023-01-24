package com.homework.util.impl;

import com.homework.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordUtil implements PasswordUtil {
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public boolean verify(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }
}