package com.example.samvel_homework_lesson_11;

import java.util.ArrayList;

public class Item {
    private int color;
    private String text;

    public static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        return items;
    }

    public Item(String text, int color){
        this.text = text;
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }


}
