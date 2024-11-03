package com.morris.dao;

import com.morris.pojo.User;
import com.morris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    Logger logger = Logger.getLogger(UserDaoTest.class);

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

    @Test
    public void getUserByIdAndName(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            Map<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("name", "陳一");

            User user = userDao.getUserByIdAndName(map);
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

    @Test
    public void addUser2(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            Map<String, Object> map = new HashMap<>();
            map.put("userId", 4);
            map.put("userName", "Map人員4");
            map.put("userPwd", 555555);

            int res = userDao.addUser2(map);
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

    @Test
    public void updateUser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int res = userDao.updateUser(new User(4, "修改人員4", "88998899"));
            if(res > 0) {
                System.out.println("修改成功");
            }

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 關閉 SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            int res = userDao.deleteUser(4);
            if(res > 0) {
                System.out.println("刪除成功");
            }

            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 關閉 SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserLike(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            List<User> userList = userDao.getUserLike("%李%");
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
    public void getUserByLimit(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserDao userDao = sqlSession.getMapper(UserDao.class);

            HashMap<String, Integer> map = new HashMap<>();
            map.put("startIndex", 1);
            map.put("pageSize", 2);

            List<User> userList = userDao.getUserByLimit(map);
            for (User user : userList) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    /*
    @Test
    public void testLog4j(){
        logger.info("info:進入了testLog4j");
        logger.debug("debug:進入了testLog4j");
        logger.error("error:進入了testLog4j");
    }
    */
}
