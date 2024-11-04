package com.morris.dao;

import com.morris.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("SELECT * FROM mybatis.teacher WHERE id = #{teacherId}")
    Teacher getTeacher(@Param("teacherId") int teacherId);
}
