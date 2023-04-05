package com.example.my_schedules.controller.todo_controller;

import com.example.my_schedules.dao.CalendarDAO;
import com.example.my_schedules.dto.TodoResultDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calendar")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CalendarController {

    @Autowired
    CalendarDAO calendarDAO;

    @PostMapping
    public TodoResultDTO getCalendarUserId(@RequestBody TodoResultDTO todoResultDTO){
        return calendarDAO.getCalendarUserId(todoResultDTO);
    }
}
