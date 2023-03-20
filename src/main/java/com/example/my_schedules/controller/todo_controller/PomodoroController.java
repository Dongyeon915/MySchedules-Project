package com.example.my_schedules.controller.todo_controller;

import com.example.my_schedules.dao.PomodoroDAO;
import com.example.my_schedules.dto.PomodoroDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pomodoro")
public class PomodoroController {

    @Autowired
    PomodoroDAO pomodoroDAO;

    @GetMapping
    public List<PomodoroDTO> getAllInterver(){
        return pomodoroDAO.getAllInterver();
    }

    @PostMapping
    public int plusInterver(@RequestBody PomodoroDTO pomodoroDTO){
        return pomodoroDAO.plusInterver(pomodoroDTO);
    }

}
