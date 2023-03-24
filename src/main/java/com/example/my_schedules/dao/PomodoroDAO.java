package com.example.my_schedules.dao;

import com.example.my_schedules.dto.PomodoroDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

// date access object
@Mapper
public interface PomodoroDAO {
    public List<PomodoroDTO> getAllInfo();

    public List<PomodoroDTO> getAllPomodoroByID(int userId);

    public int createNewDayPomodoro(PomodoroDTO pomodoroDTO);

    public PomodoroDTO getPomodoroByDate(PomodoroDTO pomodoroDTO);

    public int updateInterval(PomodoroDTO pomodoroDTO);

    public int updateRestInterval(PomodoroDTO pomodoroDTO);
}
