package com.example.my_schedules.cofig;

import com.example.my_schedules.filter.JwtAuthFilter;
import com.example.my_schedules.oauth.OAuthSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    @Autowired
    OAuthSuccessHandler authSuccessHandler;

    @Autowired
    JwtAuthFilter jwtAuthFilter;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.cors().disable();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.oauth2Login().successHandler(authSuccessHandler);
        http.oauth2Login().loginPage("/login");


//        UsernamePasswordAuthenticationFilter principal 세팅
        // JwtAuthFilter를 UsernamePasswordAuthenticationFilter 앞에 추가하여 JWT 인증 필터 등록
        http.addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated();
        return http.build();
    }
}
