package com.example.samvel_homework_lesson_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RCFoodAdapter rcFoodAdapter = new RCFoodAdapter();
    private RCItemAdapter rcItemAdapter = new RCItemAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void initFoodRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rcViewFoods);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        rcFoodAdapter.setItems(Food.getFoods());
        recyclerView.setAdapter(rcFoodAdapter);
    }
    private void intItemRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rcViewItems);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        rcItemAdapter.setItems(Item.getItems());
        recyclerView.setAdapter(rcItemAdapter);
    }
    void openSecondActivity(Food food){
        Intent intent = new Intent(
                this,
                SecondActivity.class
        );
        intent.putExtra("name",food.getFood_name());
        intent.putExtra("price",food.getFood_price());
        intent.putExtra("description",food.getDescription());
        intent.putExtra("image",food.getFood_image());
        startActivity(intent);
    }
}