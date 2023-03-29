package com.example.my_schedules.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskUserDTO {
    private TaskDTO taskDTO;
    private List<TodoResultDTO> todoResultDTOS;
}
