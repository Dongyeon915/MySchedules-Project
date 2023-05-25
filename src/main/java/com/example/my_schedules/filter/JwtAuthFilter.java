package com.example.my_schedules.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.my_schedules.dto.MyUserDTO;
import com.example.my_schedules.utils.JwtUtil;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
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

        // "Authorization" 헤더에서 JWT 토큰 추출
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token != null && token.startsWith("Bearer ") && JwtUtil.tokenVerify(token)) {
            System.out.println("JWT 검증 성공");

            // JWT 토큰 디코딩
            DecodedJWT decodedToken = JwtUtil.tokenDecoder(token);

            // 디코딩된 JWT 토큰에서 사용자 정보 추출
            MyUserDTO user = MyUserDTO.builder().
                userID(String.valueOf(decodedToken.getClaim("id")))
                .name(decodedToken.getSubject())
                .email(String.valueOf(decodedToken.getClaim("email")))
                .profile(String.valueOf(decodedToken.getClaim("profile")))
                .build();

            // 사용자 정보와 부여된 권한으로 인증 토큰 생성
//            SecurityContextHolder에 인증 토큰이 설정되지 않으면 Spring Security는 현재 사용자를 인증되지 않은 상태로 간주
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user, null,
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

//             인증 토큰을 SecurityContextHolder에 설정
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } else {
            System.out.println("JWT 검증 실패");
        }
        // 필터 체인 계속 진행
        filterChain.doFilter(request, response);
    }
}
