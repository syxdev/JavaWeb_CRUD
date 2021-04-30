package com.servier;

import com.DBUtil;
import com.dao.IUserDao;
import com.dao.UserDaoImpl;
import com.entity.User;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.util.List;

/**
 * Created by syx on 2021/04/28 10:47
 */
public class UserServiceImpl implements IUserService {
    private IUserDao iUserDao;

    public UserServiceImpl() {
        iUserDao = new UserDaoImpl();
    }

    @Override
    public User login(User user) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        User userLogin = iUserDao.login(connection, user);
        DBUtil.closeResource(connection, null, null);
        return userLogin;

    }

    @Override
    public int register(User user) {
        Connection connection = null;
        int register = 0;
        try {
            connection = DBUtil.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        register = iUserDao.register(connection, user);
        DBUtil.closeResource(connection, null, null);
        return register;
    }

    @Override
    public List<User> userList() {
        Connection connection = null;
        List<User> users = null;
        try {
            connection = DBUtil.getConnection();
            users = iUserDao.userList(connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBUtil.closeResource(connection, null, null);
        return users;
    }

    @Override
    public int addUser(User user) {
        Connection connection = null;
        int updateRow = 0;
        try {
            connection = DBUtil.getConnection();
            updateRow = iUserDao.addUser(connection, user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBUtil.closeResource(connection, null, null);
        return updateRow;
    }

    @Override
    public int deleteUserById(int id) {
        Connection connection = null;
        int updateRow = 0;
        try {
            connection = DBUtil.getConnection();
            updateRow = iUserDao.deleteUserById(connection, id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBUtil.closeResource(connection, null, null);
        return updateRow;
    }

    @Override
    public User selectUserById(int id) {
        Connection connection = null;
        User user = null;
        try {
            connection = DBUtil.getConnection();
            user = iUserDao.selectUserById(connection, id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int modifyUser(User user) {
        Connection connection = null;
        int updateRow = 0;
        try {
            connection = DBUtil.getConnection();
            updateRow = iUserDao.modifyUser(connection, user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DBUtil.closeResource(connection, null, null);
        return updateRow;
    }
}
