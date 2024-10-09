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

        try {
            // 方法一:getMapper
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            List<User> userList = userDao.getUserList();

            // 方法二:
            // List<User> userList = sqlSession.selectList("com.morris.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 關閉 SqlSession
            sqlSession.close();
        }
    }
}
