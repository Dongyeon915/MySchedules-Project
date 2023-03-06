package com.example.my_schedules.controller;

import com.example.my_schedules.dao.TaskDAO;
import com.example.my_schedules.dto.TaskDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

    @Autowired
    private TaskDAO taskDAO;

    @GetMapping
    public List<TaskDTO> getAllTask(){
        return taskDAO.getAllTask();
    }
}
