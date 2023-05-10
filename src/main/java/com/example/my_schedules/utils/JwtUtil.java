package com.example.my_schedules.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.my_schedules.dto.MyUserDTO;
import java.time.Instant;

// 토큰을 만드는 static 메소드
public class JwtUtil {

    //  생성없이 사용하기 위해 static을 선언
    private static final int AUTH_TIME = 20 * 60;
    private static final int REFRESH_TIME = 7 * 24 * 60 * 60;
    private static final String secret = "a3d1be795a2619648be93d5565a93b0318878f5ef1fdd7207112b7349cb3777b";

    public static String makeAuthToken(MyUserDTO user) {
        return JWT.create()
            .withSubject(user.getName())
            .withExpiresAt(Instant.now().plusSeconds(AUTH_TIME))
            .withClaim("id", user.getUserID())
            .withClaim("email", user.getEmail())
            .withClaim("profile", user.getProfile())
            .sign(Algorithm.HMAC512(secret));
    }

    public static String makeRefreshToken() {
        return JWT.create()
            .withExpiresAt(Instant.now().plusSeconds(REFRESH_TIME))
            .sign(Algorithm.HMAC512(secret));
    }

    public static boolean tokenVerify(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(secret)).build()
                .verify(token.substring("Bearer ".length()));
            return true;
        } catch (JWTVerificationException exception) {

            return false;
        }
    }

    public static DecodedJWT tokenDecoder(String token) {
        return JWT.require(Algorithm.HMAC512(secret)).build()
            .verify(token.substring("Bearer ".length()));
    }
}
