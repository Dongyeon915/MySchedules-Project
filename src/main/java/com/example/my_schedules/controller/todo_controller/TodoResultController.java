package com.example.my_schedules.controller.todo_controller;

import com.example.my_schedules.dao.TodoResultDAO;
import com.example.my_schedules.dto.TodoResultDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoResultController {
    @Autowired
    TodoResultDAO todoResultDAO;

// calendar의 차이점은 해당일만을 가져온다
    @PostMapping
    public TodoResultDTO getResultByUser(@RequestBody TodoResultDTO todoResultDTO){
        return todoResultDAO.getResultByUser(todoResultDTO);
    }

//    total값을 구하기위해 사용중
    @PostMapping("/userId")
    public List<TodoResultDTO> getAllResultByUser(@RequestBody TodoResultDTO todoResultDTO){
        return todoResultDAO.getAllResultByUser(todoResultDTO);
    }
}
