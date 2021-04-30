package com.dao;

import com.entity.User;

import java.sql.Connection;
import java.util.List;

/**
 * Created by syx on 2021/04/28 10:20
 */
public interface IUserDao {
    /**
     * 用户登录操作
     *
     * @param connection
     * @param user
     * @return
     */
    User login(Connection connection, User user);

    /**
     * 用户注册操作
     *
     * @param connection
     * @param user
     * @return
     */
    int register(Connection connection, User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> userList(Connection connection);

    /**
     * 添加用户
     *
     * @param connection
     * @param user
     * @return
     */
    int addUser(Connection connection, User user);

    /**
     * 通过id删除用户
     *
     * @param connection
     * @param id
     * @return
     */
    int deleteUserById(Connection connection, int id);

    /**
     * 通过ID查找用户
     *
     * @param id
     * @return
     */
    User selectUserById(Connection connection, int id);

    /**
     * 修改用户信息
     *
     * @param connection
     * @param user
     * @return
     */
    int modifyUser(Connection connection, User user);
}
