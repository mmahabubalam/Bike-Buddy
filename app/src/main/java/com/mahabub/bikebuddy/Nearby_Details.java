package com.mahabub.bikebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Nearby_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_details);

        Intent intent = getIntent();

        TextView name = findViewById(R.id.name);
        TextView area = findViewById(R.id.area);
        TextView address = findViewById(R.id.address);
        TextView number = findViewById(R.id.number);
        TextView status = findViewById(R.id.status);



        name.setText(intent.getStringExtra("name"));
        area.setText(intent.getStringExtra("area"));
        address.setText(intent.getStringExtra("address"));
        number.setText(intent.getStringExtra("number"));
        status.setText(intent.getStringExtra("status"));




    }
}