package com.whattoeat.model;

public class Food {
    int id;
    String image;
    String foodname;
    String calories;
    String description;

    public Food(){
    }

    public Food(String foodname) {
        this.foodname = foodname;
    }

    public Food(String image, String foodname, String calories, String description) {
        this.image = image;
        this.foodname = foodname;
        this.calories = calories;
        this.description = description;
    }

    public Food(int id, String image , String foodname, String calories, String description) {
        this.id = id;
        this.image = image;
        this.foodname = foodname;
        this.calories = calories;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
