package com.mahabub.bikebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        TextView name = findViewById(R.id.name);
        TextView brand = findViewById(R.id.brand);
        TextView type = findViewById(R.id.type);
        TextView engine = findViewById(R.id.engine);
        TextView output = findViewById(R.id.output);
        TextView milage = findViewById(R.id.milage);
        TextView tire = findViewById(R.id.tire);
        TextView abs = findViewById(R.id.abs);
        TextView price = findViewById(R.id.price);
        TextView speed = findViewById(R.id.speed);



        ImageView image = findViewById(R.id.imgc);

        Picasso.get().load(intent.getStringExtra("img")).placeholder(R.drawable.ktm).into(image);


        name.setText(intent.getStringExtra("name"));
        brand.setText(intent.getStringExtra("brand"));
        type.setText(intent.getStringExtra("type"));
        engine.setText(intent.getStringExtra("engine"));
        output.setText(intent.getStringExtra("output"));
        milage.setText(intent.getStringExtra("milage"));
        tire.setText(intent.getStringExtra("tire"));
        abs.setText(intent.getStringExtra("abs"));
        price.setText(intent.getStringExtra("price") + " BDT");
        speed.setText(intent.getStringExtra("speed"));



    }
}