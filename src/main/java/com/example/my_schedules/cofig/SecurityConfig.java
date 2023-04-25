package com.example.my_schedules.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    //    AuthenticationConfiguration는 애플리케이션 또는 서비스에서 사용자 인증을 구성하기 위한 설정 모음입니다.
//    이 설정은 사용자가 로그인할 때 사용되는 인증 메커니즘,
//    사용자 정보를 저장하고 보호하기 위한 보안 구성, 사용자 세션 관리를 위한 설정 등을 포함할 수 있습니다.
    @Bean
    DefaultSecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,AuthenticationConfiguration authenticationConfiguration)
        throws Exception {
        httpSecurity.csrf().disable();
//        httpSecurity.cors().disable();
        httpSecurity.authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().permitAll();
        return httpSecurity.build();
    }
}
