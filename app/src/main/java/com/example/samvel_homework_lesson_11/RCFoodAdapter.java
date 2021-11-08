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

public class RCFoodAdapter extends RecyclerView.Adapter<RCFoodAdapter.FoodViewHolder>{
    public List<Food> foods = Collections.emptyList();
    private ItemClickListener itemClickListener;

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item,parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position){
        holder.initData(foods.get(position));
    }
    @Override
    public int getItemCount(){
        return foods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public FoodViewHolder(@NonNull View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            if(itemClickListener != null)
                itemClickListener.onItemClick(view);
        }

        void initData(Food foodItem){
            AppCompatImageView image = itemView.findViewById(R.id.food_image);
            AppCompatTextView name = itemView.findViewById(R.id.food_name);
            AppCompatTextView price = itemView.findViewById(R.id.food_price);
            AppCompatTextView food_id = itemView.findViewById(R.id.food_id);

            image.setImageResource(foodItem.getFoodImage());
            name.setText(foodItem.getFoodName());
            price.setText(foodItem.getFoodPrice());
            food_id.setText(foodItem.getFoodId());
        }
    }

    public Food getById(int id){
        for(Food item : foods){
            if(item.getFoodId() == id)
                return item;
        }
        return null;
    }

    public void setItemClickListener(ItemClickListener itl){
        this.itemClickListener = itl;
    }
    public void setItems(ArrayList<Food> foods){
        this.foods = foods;
        notifyDataSetChanged();
    }
}