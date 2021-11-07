package com.example.samvel_homework_lesson_11;


import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RCItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    public List<Item> items = Collections.emptyList();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasks_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.initData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Item> items){
        this.items = items;
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder{
    private RCItemAdapter rcAdapter;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void initData(Item item){
        AppCompatTextView item_box = itemView.findViewById(R.id.item_box);

        item_box.setText(item.getText());
        item_box.setBackgroundResource(item.getColor());
    }
}
