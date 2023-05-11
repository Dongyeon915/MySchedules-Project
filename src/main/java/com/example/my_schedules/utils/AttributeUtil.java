package com.example.my_schedules.utils;

import java.util.HashMap;
import java.util.Map;

public class AttributeUtil {

    public static Map<String, Object> getOAuthAttribute(String clientName, Map<String, Object> attributes) {
        Map<String, Object> attributeResult = new HashMap<>();
        if (clientName.equals("KAKAO")) {
            Map<String,Object> result = (Map<String,Object>) attributes.get("kakao_account");
            String email = (String) result.get("email");
            String id = "" + attributes.get("id");
            Map<String,Object> profile = (Map<String,Object>) result.get("profile");
            String name = (String) profile.get("nickname");
            String profile_image = (String) profile.get("profile_image_url");
            attributeResult.put("id", id);
            attributeResult.put("name", name);
            attributeResult.put("email", email);
            attributeResult.put("profile_image", profile_image);
        } else if (clientName.equals("NAVER")) {
            Map<String, String> result = (Map<String, String>) attributes.get("response");
            String id = result.get("id");
            String email = result.get("email");
            String name = result.get("name");
            String profile_image = result.get("profile_image");
            attributeResult.put("id", id);
            attributeResult.put("name", name);
            attributeResult.put("email", email);
            attributeResult.put("profile_image", profile_image);
        }
        return attributeResult;
    }
}
