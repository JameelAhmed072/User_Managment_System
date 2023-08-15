package com.mainpackage.dao;

import com.mainpackage.entity.User;
import java.util.List;
public interface UserDao {

    public int saveUser(User user);
    public List<User> getAllUser();
    public User getUserById(int id);
    public void deleteUser(int id);
    public void update(User user);
}
