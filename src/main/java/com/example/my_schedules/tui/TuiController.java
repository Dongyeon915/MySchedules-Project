package com.example.my_schedules.tui;

import com.example.my_schedules.dao.TuiDAO;
import com.example.my_schedules.dto.TuiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tui")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TuiController {

    @Autowired
    TuiDAO tuiDAO;

    @PostMapping
    public Object setContent(@RequestBody TuiDTO tuiDTO){
        return tuiDAO.setContent(tuiDTO);
    }
}
