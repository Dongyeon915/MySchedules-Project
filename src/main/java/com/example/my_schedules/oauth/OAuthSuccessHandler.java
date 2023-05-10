package com.example.my_schedules.oauth;

import com.example.my_schedules.dto.MyUserDTO;
import com.example.my_schedules.utils.JwtUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class OAuthSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {

        MyUserDTO user = (MyUserDTO) authentication.getPrincipal();
        System.out.println("성공핸들러" + user);
        String accessToken = JwtUtil.makeAuthToken(user);
        String refreshToken = JwtUtil.makeRefreshToken();
        System.out.println("액세스 토큰" + accessToken);
        System.out.println("리프레시 토큰" + refreshToken);

        response.sendRedirect(
            "http://localhost:3000/Project/oauth2/access_token/" + accessToken + "/refresh_token/"
                + refreshToken);
    }
}
