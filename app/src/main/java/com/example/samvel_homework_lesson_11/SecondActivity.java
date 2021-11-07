package com.example.samvel_homework_lesson_11;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

public class SecondActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();

        intent.getExtras();
        AppCompatTextView name_single = findViewById(R.id.food_name_single);
        AppCompatTextView description = findViewById(R.id.twister_description);
        AppCompatImageView image = findViewById(R.id.food_image_single);
        AppCompatTextView price_single = findViewById(R.id.food_price_single);

        name_single.setText(intent.getStringExtra("name"));
        price_single.setText(intent.getStringExtra("price"));
        description.setText(intent.getStringExtra("description"));
        image.setImageResource(intent.getIntExtra("image",0));
        setContentView(R.layout.food_single);
    }
}
