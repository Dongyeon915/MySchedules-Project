package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TuiDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TuiDAO {

    public int setContent(TuiDTO tuiDTO);

}
