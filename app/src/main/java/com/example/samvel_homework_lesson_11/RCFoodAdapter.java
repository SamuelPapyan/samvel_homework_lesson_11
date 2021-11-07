package com.example.samvel_homework_lesson_11;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RCFoodAdapter extends RecyclerView.Adapter<FoodViewHolder>{
    public List<Food> foods = Collections.emptyList();

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent, false);
        return new FoodViewHolder(view);
    }

    public Food findById(int id){
        for(Food item : foods){
            if(item.getFood_id() == id)
                return item;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position){
        holder.initData(foods.get(position));
    }
    @Override
    public int getItemCount(){
        return foods.size();
    }
    public void setItems(ArrayList<Food> foods){
        this.foods = foods;
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
    private RCFoodAdapter rcFoodAdapter;
    public FoodViewHolder(@NonNull View itemView){
        super(itemView);
    }
    void initData(Food foodItem){
        AppCompatImageView image = itemView.findViewById(R.id.food_image);
        AppCompatTextView name = itemView.findViewById(R.id.food_name);
        AppCompatTextView price = itemView.findViewById(R.id.food_price);
        AppCompatTextView food_id = itemView.findViewById(R.id.food_id);

        image.setImageResource(foodItem.getFood_image());
        name.setText(foodItem.getFood_name());
        price.setText(foodItem.getFood_price());
        food_id.setText(foodItem.getFood_id());
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = ((AppCompatTextView)v.findViewById(R.id.food_id)).getText().toString();
        int parsedId = Integer.parseInt(id);
        Food food = rcFoodAdapter.findById(parsedId);
        if(food != null){
            new MainActivity().openSecondActivity(food);
        }
    }
}