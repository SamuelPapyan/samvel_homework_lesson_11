package com.example.samvel_homework_lesson_11;

import java.util.ArrayList;
import java.util.List;

public class Food {
    private static int instances = 0;

    private int foodId;
    private String foodName;
    private String foodPrice;
    private String description;
    private int foodImage;

    public Food(String foodName, String foodPrice, String description, int foodImage){
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.description = description;
        this.foodImage = foodImage;
        this.foodId = instances++;
    }

    public static ArrayList<Food> getFoods(){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("Twister 1", "1200", "This is the twister 1", R.drawable.twister));
        foods.add(new Food("Twister 2", "1300", "This is the twister 2", R.drawable.twister));
        foods.add(new Food("Twister 3", "1400", "This is the twister 3", R.drawable.twister));
        foods.add(new Food("Twister 4", "1500", "This is the twister 4", R.drawable.twister));
        foods.add(new Food("Twister 5", "1600", "This is the twister 5", R.drawable.twister));
        return foods;
    }
    public String getDescription() {
        return description;
    }
    public int getFoodImage() {
        return foodImage;
    }
    public String getFoodName() {
        return foodName;
    }
    public String getFoodPrice() {
        return foodPrice;
    }

    public int getFoodId() {
        return foodId;
    }
}
