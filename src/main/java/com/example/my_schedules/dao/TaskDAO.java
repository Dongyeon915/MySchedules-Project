package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TaskDTO;
import com.example.my_schedules.dto.TodoResultDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDAO {

    public List<TaskDTO> getAllTask();

    public int setTask(TaskDTO taskDTO);

    // 체크박스 이벤트
    public int setCheckboxComplete(TaskDTO taskDTO);

    public int putTask(TaskDTO taskDTO);

    public int deleteTask(int taskId);

    public int setDefaultRestTask(TodoResultDTO restTask);

    public int setClearTask(TodoResultDTO clear);
}
