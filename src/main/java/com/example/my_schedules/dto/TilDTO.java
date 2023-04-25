package com.example.my_schedules.dto;

import java.time.LocalDate;
import javax.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
public class TilDTO {

    private int tuiId;
    @Size(min = 1,max = 100)
    private String tuiTitle;
    private String tuiContent;
    @Size(min = 1,max = 100)
    private String type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updateDate;
}
