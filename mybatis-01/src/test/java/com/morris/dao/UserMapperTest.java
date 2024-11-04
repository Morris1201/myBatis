package com.morris.dao;

import com.morris.pojo.User;
import com.morris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void test() {

        // 獲取 SqlSession 對象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            // 方法一:getMapper
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("name", "陳一");

            User user = userMapper.getUserByIdAndName(map);
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.addUser(new User(4, "人員4", "55665566"));
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            Map<String, Object> map = new HashMap<>();
            map.put("userId", 4);
            map.put("userName", "Map人員4");
            map.put("userPwd", 555555);

            int res = userMapper.addUser2(map);
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.updateUser(new User(4, "修改人員4", "88998899"));
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.deleteUser(4);
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = userMapper.getUserLike("%李%");
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
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            HashMap<String, Integer> map = new HashMap<>();
            map.put("startIndex", 1);
            map.put("pageSize", 2);

            List<User> userList = userMapper.getUserByLimit(map);
            for (User user : userList) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = userMapper.getUsers();
            for(User user : userList ) {
                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUserById2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById2(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUser3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.addUser3(new User(6, "人員6", "6666666666"));
            sqlSession.commit();
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
