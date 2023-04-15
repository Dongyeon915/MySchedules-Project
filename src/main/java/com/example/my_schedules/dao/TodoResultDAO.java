package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TodoResultDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoResultDAO {


//    id와 date가 일치하는 유저의 clear,rest가져오기
    public TodoResultDTO getResultByUser(TodoResultDTO todoResultDTO);

//    해당유저의 rest와 clear를 가져온다
    public List<TodoResultDTO> getAllResultByUser(TodoResultDTO todoResultDTO);


}
