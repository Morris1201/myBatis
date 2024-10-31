package com.morris.dao;

import com.morris.pojo.User;

import java.util.List;

public interface UserDao {
    // 查詢全部用戶
    List<User> getUserList();

    // 根據ID查詢用戶
    User getUserById(int id);

    // insert一個用戶
    int addUser(User user);

    // 修改用戶
    int updateUser(User user);

    // 刪除一個用戶
    int deleteUser(int id);
}
