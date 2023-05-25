package com.example.my_schedules.dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyUserDTO implements OAuth2User {
    private String userID;
    private String email;
    private String name;
    private String profile;
    private LocalDate join_date;
    private Map<String, Object> attributes;
    private Collection<? extends GrantedAuthority> authorities;
}
