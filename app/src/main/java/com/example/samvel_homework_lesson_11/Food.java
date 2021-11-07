package com.example.samvel_homework_lesson_11;

import java.util.ArrayList;
import java.util.List;

public class Food {
    private static int instances = 0;

    private int food_id;
    private String food_name;
    private String food_price;
    private String description;
    private int food_image;

    public Food(String food_name, String food_price, String description, int food_image){
        this.food_name = food_name;
        this.food_price = food_price;
        this.description = description;
        this.food_image = food_image;
        this.food_id = instances++;
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
    public int getFood_image() {
        return food_image;
    }
    public String getFood_name() {
        return food_name;
    }
    public String getFood_price() {
        return food_price;
    }

    public int getFood_id() {
        return food_id;
    }
}
