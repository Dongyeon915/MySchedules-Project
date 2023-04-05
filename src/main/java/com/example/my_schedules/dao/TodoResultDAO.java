package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TodoResultDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoResultDAO {


//    id와 date가 일치하는 유저의 clear,rest가져오기
    public TodoResultDTO getResultByUser(TodoResultDTO todoResultDTO);

}
