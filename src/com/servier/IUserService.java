package com.servier;

import com.entity.User;

import java.util.List;

/**
 * Created by syx on 2021/04/28 10:45
 */
public interface IUserService {
    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> userList();

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据Id删除用户
     *
     * @param id
     * @return
     */
    int deleteUserById(int id);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    User selectUserById(int id);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    int modifyUser(User user);
}
