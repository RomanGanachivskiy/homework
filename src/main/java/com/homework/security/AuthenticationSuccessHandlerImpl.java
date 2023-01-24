package com.homework.security;

import com.homework.enums.Role;
import com.homework.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private static final String CABINET_URL = "/cabinet";
    private static final String ADMIN_URL = "/admin";
    private static final String LOGIN_URL = "/login";

    @Autowired
    private PersonService personService;

    @Autowired
    private RedirectStrategy redirectStrategy;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        var email = authentication.getName();
        var person = personService.getPersonByEmail(email);
        try {
            if (person.getRole().equals(Role.ADMIN)) {
                redirectStrategy.sendRedirect(request, response, ADMIN_URL);
            } else {
                redirectStrategy.sendRedirect(request, response, CABINET_URL);
            }
        } catch (Exception e) {
            redirectStrategy.sendRedirect(request, response, LOGIN_URL);
        }
    }
}
