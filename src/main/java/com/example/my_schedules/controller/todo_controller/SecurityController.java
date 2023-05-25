package com.example.my_schedules.controller.todo_controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityController {

    @GetMapping("/login")
    public ResponseEntity<Object> loginFailHandler() {
        return new ResponseEntity<Object>("가입되지 않은 사용자 입니다.", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/context")
    public Object getContextInfo() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext;
    }


    @GetMapping("/authentication")
    public Object getAuthenticationInfo() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return authentication;
    }

    @GetMapping("/authentication/principal")
    public Object getPrincipalInfo() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }


    @GetMapping("/authentication/credential")
    public Object getcredentialInfo() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return authentication.getCredentials();
    }

    @GetMapping("/authentication/authorities")
    public Object getAuthoritiesInfo() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}
