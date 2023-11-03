package com.whattoeat.service;

import com.whattoeat.dao.UserDAO;
import com.whattoeat.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    public List<User> selectAllUsers(){
        return userDAO.selectAllUsers();
    }
    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }
    public void updateUserLogin(User user) throws SQLException {
        userDAO.updateUserLogin(user);
    }
    public void updateUserLogout() throws SQLException {
        userDAO.updateUserLogout();
    }
    public User selectLoginUser(String email){
        return userDAO.selectLoginUser(email);
    }
}
