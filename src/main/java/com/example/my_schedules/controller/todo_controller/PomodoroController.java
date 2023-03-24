package com.example.my_schedules.controller.todo_controller;

import com.example.my_schedules.dao.PomodoroDAO;
import com.example.my_schedules.dto.PomodoroDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/userId/{userid}")
    public List<PomodoroDTO> getPomodoroByID(@PathVariable int userid){
        return pomodoroDAO.getAllPomodoroByID(userid);
    }

    @PostMapping("/interval/{type}")
    public PomodoroDTO getUserInfo(@RequestBody PomodoroDTO pomodoroDTO,@PathVariable String type) {
        if (pomodoroDAO.getPomodoroByDate(pomodoroDTO) == null) {
            pomodoroDTO.setRest(10);
            pomodoroDTO.setMinute(20);
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

//    @GetMapping
//    PomodoroDTO getPomodoro(@RequestParam(required = false) Integer userID,
//        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
//        return pomodoroDAO.getPomodoro(date.toString());
//    }

//    최초 유저 정보 입력란
//    @PutMapping
//    public int setUserInfo(@RequestBody PomodoroDTO pomodoroDTO) {
//        // date, userID colume
//        System.out.println(pomodoroDTO.toString());
//        return pomodoroDAO.setUserInfo(pomodoroDTO);
//    }

// userId와 일치하는 user의 interval값을 증가
//    @PutMapping("/interval")
//    public int updateInterval(@RequestBody PomodoroDTO pomodoroDTO){
//        return pomodoroDAO.updateInterval(pomodoroDTO);
//    }

    @PutMapping("/restinterval")
    public int updaterestInterval(@RequestBody PomodoroDTO pomodoroDTO){
        return pomodoroDAO.updateRestInterval(pomodoroDTO);
    }
}