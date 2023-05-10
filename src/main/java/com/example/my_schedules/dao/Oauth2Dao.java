package com.example.my_schedules.dao;

import com.example.my_schedules.dto.MyUserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Oauth2Dao {

    public MyUserDTO getUserByEmail(String email);

    public int saveUser(MyUserDTO user);
}
