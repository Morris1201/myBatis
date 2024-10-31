package com.morris.dao;

import com.morris.pojo.User;

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
}
