package com.morris.dao;

import com.morris.pojo.Student;

import java.util.List;

public interface StudentMapper {
    // 查詢所有的學生訊息，以及對應的老師信息
    public List<Student> getStudent();

    // 方法2
    public List<Student> getStudent2();
}
