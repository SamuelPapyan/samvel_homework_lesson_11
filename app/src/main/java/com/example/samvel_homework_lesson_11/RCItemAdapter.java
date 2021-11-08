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


public class RCItemAdapter extends RecyclerView.Adapter<RCItemAdapter.ItemViewHolder> {

    public List<Item> items = Collections.emptyList();
    private ItemClickListener itemClickListener;

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

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RCItemAdapter rcAdapter;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }
        public void initData(Item item){
            AppCompatTextView item_box = itemView.findViewById(R.id.item_box);

            item_box.setText(item.getText());
            item_box.setBackgroundResource(item.getColor());
        }
        public void onClick(View view){
            if(itemClickListener != null)
                itemClickListener.onItemClick(view);
        }
    }

    private int getRedItemId(){
        for(Item item : items)
            if(item.getColor() == R.drawable.rounded_red_box)
                return item.getItemId();
        return -1;
    }
    public void setItems(ArrayList<Item> items){
        this.items = items;
        notifyDataSetChanged();
    }
    public void setItemClickListener(ItemClickListener itl){
        this.itemClickListener = itl;
    }
    public Item getItem(int id){
        for(Item item : items)
            if(item.getItemId() == id)
                return item;
        return null;
    }
    public void swapColors(int id){
        int redId = getRedItemId();
        if(redId > -1){
            int color = items.get(id).getColor();
            items.get(id).setColor(items.get(redId).getColor());
            items.get(redId).setColor(color);
            notifyDataSetChanged();
        }
    }
}
