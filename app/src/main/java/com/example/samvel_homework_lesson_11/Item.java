package com.example.samvel_homework_lesson_11;

import java.util.ArrayList;

public class Item {
    private static int instances = 0;

    private int itemId;
    private int color;
    private String text;

    public static ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Text 1", R.drawable.rounded_red_box));
        items.add(new Item("Text 2", R.drawable.rounded_black_box_2));
        items.add(new Item("Text 3", R.drawable.rounded_black_box_2));
        items.add(new Item("Text 4", R.drawable.rounded_black_box_2));
        items.add(new Item("Text 5", R.drawable.rounded_black_box_2));
        items.add(new Item("Text 6", R.drawable.rounded_black_box_2));
        return items;
    }

    public Item(String text, int color){
        this.text = text;
        this.color = color;
        this.itemId = instances++;
    }

    public int getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public int getItemId() {
        return itemId;
    }

    public void setColor(int color){
        this.color = color;
    }
}
