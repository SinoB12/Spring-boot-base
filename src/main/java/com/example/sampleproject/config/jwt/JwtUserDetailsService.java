package com.example.sampleproject.config.jwt;

import com.example.sampleproject.entity.Employee;
import com.example.sampleproject.repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
public class JwtUserDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final JwtTokenUtil jwtTokenUtil;
    public JwtUserDetailsService(EmployeeRepository employeeRepository, JwtTokenUtil jwtTokenUtil) {
        this.employeeRepository = employeeRepository;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByEmail(username);

        if (!ObjectUtils.isEmpty(employee)) {
            // get list role of employee
            List<GrantedAuthority> authorityList = employeeRepository.findListRoleById(employee.getEmpNo());
            return new User(employee.getEmpName(), " password is not yet",authorityList);
        } else {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
    }
}
