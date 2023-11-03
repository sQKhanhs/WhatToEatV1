package com.whattoeat.dao;

import com.whattoeat.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/whattoeat?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "sassases";

    private static final String INSERT_USERS_SQL = "INSERT INTO users (username, email, password) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String UPDATE_LOGIN_USER = "UPDATE users set login = 1 where email = ?";
    private static final String UPDATE_LOGOUT_USER = "UPDATE users set login = 0";
    private static final String SELECT_LOGIN_USER = "select * from users where login = 1";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                users.add(new User(id, username, email, password));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    public boolean updateUserLogin(User user) throws SQLException {
        System.out.println(UPDATE_LOGIN_USER);
        boolean rowUpdated;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_LOGIN_USER);
            statement.setString(1, user.getEmail());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
    public boolean updateUserLogout() throws SQLException {
        System.out.println(UPDATE_LOGOUT_USER);
        boolean rowUpdated;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_LOGOUT_USER);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
    public User selectLoginUser(String email) {
        User loginUser = new User();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_USER);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                email = rs.getString("email");
                String username = rs.getString("username");
                loginUser = new User(email, username);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return loginUser;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
