package com.mainpackage.dao;

import com.mainpackage.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Transactional
    public int saveUser(User user) {

        int i = (Integer) hibernateTemplate.save(user);
        return i;
    }
    public List<User> getAllUser() {

        List<User> list = hibernateTemplate.loadAll(User.class);
        return list;
    }
    public User getUserById(int id) {

        User user = hibernateTemplate.get(User.class,id);
        return user;
    }
    @Transactional
    public void deleteUser(int id) {
        User user = hibernateTemplate.get(User.class,id);
        hibernateTemplate.delete(user);
    }
    @Transactional
    public void update(User user) {
        hibernateTemplate.update(user);
    }
}
