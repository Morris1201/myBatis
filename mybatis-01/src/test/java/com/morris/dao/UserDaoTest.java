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

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = userDao.getUserById(1);
            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 關閉 SqlSession
            sqlSession.close();
        }
    }

    // 增刪改需要提交事務
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int res = userDao.addUser(new User(4, "人員4", "55665566"));
            if(res > 0) {
                System.out.println("新增成功");
            }

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 關閉 SqlSession
            sqlSession.close();
        }
    }
}
