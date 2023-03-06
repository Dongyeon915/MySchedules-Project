package com.example.my_schedules.dto;

import lombok.Data;

@Data
public class TaskDTO {
    private Integer task_id;
    private String join_date_id;
    private String todo_task;
    private Integer checkbox_complete;
    private Integer rest_task;
    private Integer clear_task;
}
