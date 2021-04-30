package com.dao;

import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syx on 2021/04/28 10:20
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public User login(Connection connection, User user) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        if (null != connection) {
            try {
                String sql = "select * from library_user where user_name=?";
                Object[] params = {user.getUsername()};
                pstm = connection.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
                rs = pstm.executeQuery();
                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("user_name"));
                    user.setPassword(rs.getString("user_password"));
                    user.setAddress(rs.getString("address"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setPhone(rs.getString("phone"));
                    user.setGender(rs.getString("gender"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int register(Connection connection, User user) {
        PreparedStatement pstm = null;
        int updateRow = 0;
        if (null != connection) {
            String sql = "insert into library_user(user_name,user_password,gender,birthday,phone,address) values (?,?,?,?,?,?)";
            Object[] params = {user.getUsername(), user.getPassword(), user.getGender(), user.getBirthday(), user.getPhone(), user.getAddress()};
            try {
                pstm = connection.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
                updateRow = pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updateRow;
    }

    @Override
    public List<User> userList(Connection connection) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        if (null != connection) {
            String sql = "select * from library_user";
            try {
                pstm = connection.prepareStatement(sql);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("user_name"));
                    user.setPassword(rs.getString("user_password"));
                    user.setPhone(rs.getString("phone"));
                    user.setAddress(rs.getString("address"));
                    user.setGender(rs.getString("gender"));
                    user.setBirthday(rs.getDate("birthday"));
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
    public int addUser(Connection connection, User user) {
        PreparedStatement pstm = null;
        int upadteRow = 0;
        if (null != connection) {
            String sql = "insert into library_user(user_name,user_password,gender,birthday,phone,address) values (?,?,?,?,?,?)";
            try {
                pstm = connection.prepareStatement(sql);
                Object[] params = {user.getUsername(), user.getPassword(), user.getGender(), user.getBirthday(), user.getPhone(), user.getAddress()};
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
                upadteRow = pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return upadteRow;
    }

    @Override
    public int deleteUserById(Connection connection, int id) {
        PreparedStatement pstm = null;
        int updateRow = 0;
        if (null != connection) {
            String sql = "delete from library_user where id=?";
            try {
                pstm = connection.prepareStatement(sql);
                Object[] params = {id};
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
                updateRow = pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updateRow;
    }

    @Override
    public User selectUserById(Connection connection, int id) {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = new User();
        if (null != connection) {
            String sql = "select * from library_user where id=?";
            try {
                pstm = connection.prepareStatement(sql);
                Object[] params = {id};
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
                rs = pstm.executeQuery();
                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("user_name"));
                    user.setPassword(rs.getString("user_password"));
                    user.setGender(rs.getString("gender"));
                    user.setPhone(rs.getString("phone"));
                    user.setBirthday(rs.getDate("birthday"));
                    user.setAddress(rs.getString("address"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public int modifyUser(Connection connection, User user) {
        PreparedStatement pstm = null;
        int updateRow = 0;
        if (null != connection) {
            String sql = "update library_user set user_name=?,user_password=?,gender=?,birthday=?,phone=?,address=? where id=?";
            Object[] params = {user.getUsername(), user.getPassword(), user.getGender(), user.getBirthday(), user.getPhone(), user.getAddress(), user.getId()};
            try {
                pstm = connection.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    pstm.setObject(i + 1, params[i]);
                }
                updateRow = pstm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updateRow;
    }
}