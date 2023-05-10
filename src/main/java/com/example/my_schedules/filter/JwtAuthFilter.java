package com.example.my_schedules.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.my_schedules.dto.MyUserDTO;
import com.example.my_schedules.utils.JwtUtil;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null && token.startsWith("Bearer ") && JwtUtil.tokenVerify(token)) {
            System.out.println("JWT 검증 성공");

            DecodedJWT decodedToken = JwtUtil.tokenDecoder(token);

            MyUserDTO user = MyUserDTO.builder().
                userID(String.valueOf(decodedToken.getClaim("id")))
                .name(decodedToken.getSubject())
                .email(String.valueOf(decodedToken.getClaim("email")))
                .profile(String.valueOf(decodedToken.getClaim("profile")))
                .build();

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user, null,
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } else {
            System.out.println("JWT 검증 실패");
        }
        filterChain.doFilter(request, response);
    }
}
