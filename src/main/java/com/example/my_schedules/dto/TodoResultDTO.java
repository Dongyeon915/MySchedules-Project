package com.example.my_schedules.dto;

import java.util.Date;
import lombok.Data;

@Data
public class TodoResultDTO {
    private Date date;
    private Integer rest_task;
    private Integer clear_task;
}
