package com.morris.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    // 學生關聯老師
    private Teacher teacher;
}
