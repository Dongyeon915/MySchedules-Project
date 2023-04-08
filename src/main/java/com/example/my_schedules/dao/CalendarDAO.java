package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TaskDTO;
import com.example.my_schedules.dto.TodoResultDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CalendarDAO {
    //    달력을 위한 해당유저의 정보를 가져오는 메소드
    public TodoResultDTO getCalendarUserId(TodoResultDTO todoResultDTO);
    public List<TodoResultDTO> allCalendarUserId(TodoResultDTO todoResultDTO);
}
