package com.morris.dao;

import com.morris.pojo.User;
import com.morris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void test() {
        // 獲取 SqlSession 對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 方法一:getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        // 關閉 SqlSession
        sqlSession.close();
    }
}
