package com.example.my_schedules.dto;

import java.util.Date;
import lombok.Data;

@Data
public class TaskDTO {
    private Date date;
    private Integer task_id;
    private String todo_task;
    private Boolean checkbox_complete;
    private Date complete_time;
}
