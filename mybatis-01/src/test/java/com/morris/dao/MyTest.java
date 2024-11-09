package com.morris.dao;

import com.morris.pojo.Student;
import com.morris.pojo.Teacher;
import com.morris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void getTeacher(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

            Teacher teacher = teacherMapper.getTeacher(1);
            System.out.println(teacher);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getStudent(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

            List<Student> studentList = studentMapper.getStudent();
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
