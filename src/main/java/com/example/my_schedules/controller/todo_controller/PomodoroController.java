package com.example.my_schedules.controller.todo_controller;

import com.example.my_schedules.dao.PomodoroDAO;
import com.example.my_schedules.dto.PomodoroDTO;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pomodoro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PomodoroController {

    @Autowired
    PomodoroDAO pomodoroDAO;

    @GetMapping
    public List<PomodoroDTO> getAllInfo() {
        return pomodoroDAO.getAllInfo();
    }

    @PostMapping
    public PomodoroDTO getPomodoroByDate(@RequestBody PomodoroDTO pomodoroDTO){
        return pomodoroDAO.getPomodoroByDate(pomodoroDTO);
    }

    @PostMapping("/userId")
    public List<PomodoroDTO> getPomodoroByID(@RequestBody PomodoroDTO pomodoroDTO){
        return pomodoroDAO.getPomodoroByID(pomodoroDTO);
    }

    @PostMapping("/interval/{type}")
    public PomodoroDTO getUserInfo(@RequestBody PomodoroDTO pomodoroDTO,@PathVariable String type) {
        if (pomodoroDAO.getPomodoroByDate(pomodoroDTO) == null) {
            pomodoroDTO.setRest(pomodoroDTO.getRest());
            pomodoroDTO.setMinute(pomodoroDTO.getMinute());
            pomodoroDTO.setInterval(0);
            pomodoroDTO.setRestInterval(0);
            pomodoroDAO.createNewDayPomodoro(pomodoroDTO);
        }
        if (type.equals("rest")) {

            pomodoroDAO.updateRestInterval(pomodoroDTO);
        } else {
            pomodoroDAO.updateInterval(pomodoroDTO);
        }
        return pomodoroDTO;
    }

    @PutMapping("/restinterval")
    public int updaterestInterval(@RequestBody PomodoroDTO pomodoroDTO){
        return pomodoroDAO.updateRestInterval(pomodoroDTO);
    }
}