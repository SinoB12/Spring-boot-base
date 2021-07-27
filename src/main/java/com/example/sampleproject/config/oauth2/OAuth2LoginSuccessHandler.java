package com.example.sampleproject.config.oauth2;

import com.example.sampleproject.entity.Employee;
import com.example.sampleproject.service.EmployeeService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final EmployeeService employeeService;

    public OAuth2LoginSuccessHandler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = customOAuth2User.getEmail();
        Employee employee = employeeService.getByEmail(email);
        if(ObjectUtils.isEmpty(employee)){
           // register employee
            String name = customOAuth2User.getName();
            employeeService.registerNewEmployeeAfterLoginSuccess(email,name);
        }else{
            // login success , return employee info
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
