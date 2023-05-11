package com.example.my_schedules.filterDto;

import com.example.my_schedules.dao.Oauth2Dao;
import com.example.my_schedules.dto.MyUserDTO;
import com.example.my_schedules.utils.AttributeUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

// db에 저장된 사용자를 가져올때 사용
// DaoAuthenticationProvider는 반드시 1개의 UserDetailsService를 발견할 수 있어야 한다. 만약 없으면
// InmemoryUserDetailsManager에 [username=user, password=(서버가 생성한 패스워드)]인 사용자가 등록되어 제공됩니다.
@Service
public class MyOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    Oauth2Dao oauth2Dao;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("유저 서비스 구역");
        System.out.println("리퀘스트" + userRequest);
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String clientName = userRequest.getClientRegistration().getClientName().toUpperCase();
        Map<String, Object> attributes = AttributeUtil.getOAuthAttribute(clientName,
            oAuth2User.getAttributes());

        String email = (String) attributes.get("email");
        MyUserDTO user = oauth2Dao.getUserByEmail(email);
            // 회원가입 작성 !
            if (oauth2Dao.getUserByEmail(email) == null){
                    MyUserDTO myUser = MyUserDTO.builder().userID((String) attributes.get("id"))
                        .name((String) attributes.get("name")).profile(
                            (String) attributes.get("profile_image")).email(
                            (String) attributes.get("email")).build();
                    oauth2Dao.saveUser(myUser);
            }else if (oauth2Dao.getUserByEmail(email) != null){
                MyUserDTO myUserDTO = MyUserDTO.builder().userID((String) attributes.get("id")).name(
                    String.valueOf(attributes.get("name"))).profile(
                    (String) attributes.get("profile_image")).build();
                oauth2Dao.updateUser(myUserDTO);
            }
        user.setAttributes(attributes);
        user.setAuthorities(oAuth2User.getAuthorities());
//        성공 핸들러로 가정
        return user;
    }
}