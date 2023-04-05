package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TaskDTO;
import com.example.my_schedules.dto.TodoResultDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDAO {

    //  모든 userId 정보를 가져온다 미사용
    public List<TaskDTO> getAllTask();

    //  userId가 일치하는 user만 가져온다 미사용
    public List<TaskDTO> getUserById(int id);

    //  날짜포함 테스트
    public List<TaskDTO> getUserById(TaskDTO taskDTO);

    public int setTask(TaskDTO taskDTO);

    // 체크박스 이벤트
    public int setCheckboxComplete(TaskDTO taskDTO);

    public int putTask(TaskDTO taskDTO);

    public int deleteTask(int taskId);

    public int setDefaultRestTask(TodoResultDTO restTask);

    public int setClearTask(TodoResultDTO clear);

}
