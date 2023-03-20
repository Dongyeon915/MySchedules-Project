package com.example.my_schedules.dao;

import com.example.my_schedules.dto.PomodoroDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PomodoroDAO {
    public List<PomodoroDTO> getAllInterver();

    public int plusInterver(PomodoroDTO pomodoroDTO);
}
