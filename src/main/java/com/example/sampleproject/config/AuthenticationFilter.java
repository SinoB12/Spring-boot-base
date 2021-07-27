package com.example.sampleproject.config;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class AuthenticationFilter {

    AntPathRequestMatcher matcher = new AntPathRequestMatcher("/login", "POST");

}
