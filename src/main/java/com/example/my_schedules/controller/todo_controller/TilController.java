package com.example.my_schedules.controller.todo_controller;

import com.example.my_schedules.dao.TilDAO;
import com.example.my_schedules.dto.TilDTO;
import com.example.my_schedules.dto.TuiDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/til")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TilController {

    @Autowired
    TilDAO tilDAO;

//    작업중
    @GetMapping("/page/{pageId}")
    public List<TilDTO> getPage(@PathVariable int pageId){
        return tilDAO.getPage(pageId);
    }


    @GetMapping
    public List<TilDTO> getUsetByTilContent(){
        return tilDAO.getUsetByTilContent();
    }

    @GetMapping("/{id}")
    public TilDTO getTilContentById(@PathVariable int id){
        return tilDAO.getTilContentById(id);
    }

    @PostMapping
    public int setContent(@RequestBody TilDTO tilDTO){
        tilDAO.setContent(tilDTO);
        return tilDTO.getTuiId();
    }

    @PutMapping
    public int updateContent(@RequestBody TilDTO tilDTO){
        tilDAO.updateContent(tilDTO);
        return tilDTO.getTuiId();
    }

    @DeleteMapping("/{id}")
    public int deleteContent(@PathVariable int id){
        return tilDAO.deleteContent(id);
    }

}
