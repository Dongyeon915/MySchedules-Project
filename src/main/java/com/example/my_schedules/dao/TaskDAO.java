package com.example.my_schedules.dao;

import com.example.my_schedules.dto.TaskDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskDAO {
    public List<TaskDTO> getAllTask();
}
