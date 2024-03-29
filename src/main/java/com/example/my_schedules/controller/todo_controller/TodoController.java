package com.example.my_schedules.controller.todo_controller;

import com.example.my_schedules.dao.TaskDAO;
import com.example.my_schedules.dto.TaskDTO;
import com.example.my_schedules.dto.TodoResultDTO;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/schedules")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {

    @Autowired
    private TaskDAO taskDAO;


    @PostMapping("/user")
    public List<TaskDTO> getUserById(@RequestBody TaskDTO taskDTO) {
        return taskDAO.getUserById(taskDTO);
    }

    @PostMapping
    public ResponseEntity<Object> setTask(@Valid @RequestBody TaskDTO taskDTO) {
        TodoResultDTO restValue = new TodoResultDTO();
        restValue.setUserId(taskDTO.getUserId());
        restValue.setDate(taskDTO.getDate());
        restValue.setRestTask(1);
        restValue.setClearTask(0);
//      오류방지 입력
//        restValue.setMemberId(0);
        taskDAO.setDefaultRestTask(restValue);
        int result = taskDAO.setTask(taskDTO);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Task를 확인 해주세요");
        }
        return ResponseEntity.status(HttpStatus.OK).body(taskDTO);
    }

    @PutMapping("/checkbox/{task_id}")
    public Object setCheckboxComplete(@RequestBody TaskDTO taskDTO) {
        TodoResultDTO clear = new TodoResultDTO();
        clear.setUserId(taskDTO.getUserId());
        clear.setDate(taskDTO.getDate());
        taskDAO.setClearTask(clear);
        return taskDAO.setCheckboxComplete(taskDTO);
    }

    @PutMapping
    public ResponseEntity<Object> putTask(@Valid @RequestBody TaskDTO taskDTO) {
        int result = taskDAO.putTask(taskDTO);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("수정 값을 확인 해주세요");
        }
        return ResponseEntity.status(HttpStatus.OK).body(taskDTO);
    }

    @DeleteMapping("/{task_id}")
    public ResponseEntity<Object> deleteTask(@PathVariable int task_id) {
        TodoResultDTO todoResultDTO = new TodoResultDTO();
        int result = taskDAO.deleteTask(task_id);
        if (result != 1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("삭제 값을 확인해주세요");
        }
        return ResponseEntity.status(HttpStatus.OK).body(task_id);
    }

    @DeleteMapping
    public int deleteTaskResult(@RequestBody TodoResultDTO todoResultDTO) {
        return taskDAO.deleteTaskResult(todoResultDTO);
    }
}