//package com.example.my_schedules.oauth;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OAuthFaillHandler implements AuthenticationFailureHandler {
//
////    OAuth2UserService # loadUser() 가 실행이 완료되면
////    세션 방식 로그인에서는 시큐리티 세션(의 Authentication 객체)에 사용자 정보가 들어가게 됩니다.
//
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//        AuthenticationException exception) throws IOException, ServletException {
//        response.sendRedirect("http://localhost:3000/Project/login");
//    }
//}
