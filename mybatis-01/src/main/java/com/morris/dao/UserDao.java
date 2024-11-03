package com.morris.dao;

import com.morris.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserDao {
    // 查詢全部用戶
    List<User> getUserList();

    // 根據ID查詢用戶
    User getUserById(int id);

    User getUserByIdAndName(Map<String, Object> map);

    // insert一個用戶
    int addUser(User user);

    int addUser2(Map<String, Object> map);

    // 修改用戶
    int updateUser(User user);

    // 刪除一個用戶
    int deleteUser(int id);

    // 模糊查詢
    List<User> getUserLike(String name);

    // 分頁
    List<User> getUserByLimit(Map<String, Integer> map);

    @Select("SELECT * FROM mybatis.user")
    List<User> getUsers();

    // 方法存在多個參數，所有的參數前面必須加上 @Param("id")註解
    @Select("SELECT * FROM mybatis.user WHERE id = #{id}")
    User getUserById2(@Param("id") int id);

    @Insert("INSERT INTO user(id, name, pwd) VALUES (#{id}, #{name}, #{pwd})")
    int addUser3(User user);
}
