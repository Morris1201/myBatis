package com.morris.dao;

import com.morris.pojo.Teacher;
import com.morris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
}
