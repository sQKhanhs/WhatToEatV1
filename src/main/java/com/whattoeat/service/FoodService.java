package com.whattoeat.service;

import com.whattoeat.dao.FoodDAO;
import com.whattoeat.model.Food;

import java.sql.SQLException;
import java.util.List;

public class FoodService {
    private FoodDAO foodDAO = new FoodDAO();
    public List<Food> pagingFood(int index){
        return foodDAO.pagingFood(index);
    }
    public List<Food> pagingFoodSearch(int index){
        return foodDAO.pagingFoodSearch(index);
    }
    public void updateSearchFood(Food food) throws SQLException {
        foodDAO.updateSearchFood(food);
    }
    public void updateUnsearchFoodList() throws SQLException {
        foodDAO.updateUnsearchFoodlist();
    }
    public int getTotalFood(){
        return foodDAO.getTotalFood();
    }
    public int getTotalFoodSearch(){
        return foodDAO.getTotalFoodSearch();
    }
}
