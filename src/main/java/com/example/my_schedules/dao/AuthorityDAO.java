package com.example.my_schedules.dao;

import com.example.my_schedules.dto.AuthorityDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthorityDAO {

    public int setUserAuthority(AuthorityDTO authorityDTO);
}
