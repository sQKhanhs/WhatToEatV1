package com.whattoeat.dao;

import com.whattoeat.model.Food;
import com.whattoeat.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/whattoeat?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "sassases";
    private static final String GET_TOTAL_FOODS = "SELECT COUNT(*) FROM FOODS";
    private static final String GET_TOTAL_FOODS_SEARCH = "SELECT COUNT(*) FROM FOODS where search = 1";
    private static final String GET_PAGING_FOODS = "SELECT * FROM foods ORDER BY id limit 4 " + "offset ?" ;
    private static final String GET_PAGING_FOODS_SEARCH = "SELECT * FROM foods where search = 1 ORDER BY id limit 4 " + "offset ?";
    private static final String UPDATE_UNSEARCH_FOODLIST = "UPDATE foods set search = 0";
    private static final String UPDATE_SEARCH_FOOD = "UPDATE foods set search = 1 where foodname like CONCAT(?,'%')";

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
    public int getTotalFood(){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TOTAL_FOODS);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0 ;
    }

    public int getTotalFoodSearch(){
        try{
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TOTAL_FOODS_SEARCH);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0 ;
    }

    public List<Food> pagingFood(int index){
        List<Food> foodList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PAGING_FOODS);
            preparedStatement.setInt(1, (index-1)*4);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String foodname = rs.getString("foodname");
                String image = rs.getString("image");
                String calories = rs.getString("calories");
                String description = rs.getString("description");
                foodList.add(new Food(id, image ,foodname, calories, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return foodList;
    }

    public List<Food> pagingFoodSearch(int index){
        List<Food> foodList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PAGING_FOODS_SEARCH);
            preparedStatement.setInt(1, (index-1)*4);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String foodname = rs.getString("foodname");
                String image = rs.getString("image");
                String calories = rs.getString("calories");
                String description = rs.getString("description");
                foodList.add(new Food(image ,foodname, calories, description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return foodList;
    }
    public boolean updateSearchFood(Food food) throws SQLException {
        System.out.println(UPDATE_SEARCH_FOOD);
        boolean rowUpdated;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_SEARCH_FOOD);
            statement.setString(1, food.getFoodname());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
    public boolean updateUnsearchFoodlist() throws SQLException {
        System.out.println(UPDATE_UNSEARCH_FOODLIST);
        boolean rowUpdated;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_UNSEARCH_FOODLIST);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
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
