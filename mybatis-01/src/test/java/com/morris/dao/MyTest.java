package com.morris.dao;

import com.morris.pojo.Student;
import com.morris.pojo.Teacher;
import com.morris.pojo.User;
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

    @Test
    public void getStudent2(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

            List<Student> studentList = studentMapper.getStudent2();
            for (Student student : studentList) {
                System.out.println(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void tese(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = userMapper.getUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

        try {
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

            User user2 = userMapper2.getUserById(1);
            System.out.println(user2);

            User user3 = userMapper2.getUserById(2);

            System.out.println(user2);
            System.out.println(user3);

            User user4 = userMapper2.getUserById(2);
            System.out.println(user4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession2.close();
        }
    }
}
