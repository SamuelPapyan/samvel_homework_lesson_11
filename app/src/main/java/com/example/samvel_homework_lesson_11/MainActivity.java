package com.example.samvel_homework_lesson_11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RCFoodAdapter rcFoodAdapter = new RCFoodAdapter();
    private RCItemAdapter rcItemAdapter = new RCItemAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFoodRecyclerView();
        initItemRecyclerView();
    }
    private void initFoodRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rcViewFoods);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        rcFoodAdapter.setItems(Food.getFoods());
        rcFoodAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view) {
                String id = ((AppCompatTextView)view.findViewById(R.id.food_id)).getText().toString();
                int parsedId = Integer.parseInt(id);
                Food food = rcFoodAdapter.getById(parsedId);
                if(food != null){
                    openSecondActivity(food);
                }
            }
        });
        recyclerView.setAdapter(rcFoodAdapter);
    }
    private void initItemRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.rcViewItems);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        rcItemAdapter.setItems(Item.getItems());
        rcItemAdapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view) {
                String id = ((AppCompatTextView)view.findViewById(R.id.food_id)).getText().toString();
                int parsedId = Integer.parseInt(id);
                rcItemAdapter.swapColors(parsedId);
            }
        });
        recyclerView.setAdapter(rcItemAdapter);

    }
    void openSecondActivity(Food food){
        Intent intent = new Intent(
                this,
                SecondActivity.class
        );
        intent.putExtra("name",food.getFoodName());
        intent.putExtra("price",food.getFoodPrice());
        intent.putExtra("description",food.getDescription());
        intent.putExtra("image",food.getFoodImage());
        startActivity(intent);
    }
}