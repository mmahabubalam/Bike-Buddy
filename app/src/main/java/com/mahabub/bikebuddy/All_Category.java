package com.mahabub.bikebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class All_Category extends AppCompatActivity {

    GridView gridView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap<>();
    public int category[] = {R.drawable.sprots,R.drawable.nakedsp,R.drawable.cafe_racer,R.drawable.advanture,
            R.drawable.cruizer,R.drawable.dirt, R.drawable.standard, R.drawable.scooty, R.drawable.electric,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        gridView = findViewById(R.id.GridView);


        CreateTable();
        MyAdapter adapter = new MyAdapter();
        gridView.setAdapter(adapter);
    }

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview = layoutInflater.inflate(R.layout.items,viewGroup,false);


            ImageView Cover_image = myview.findViewById(R.id.Cover_image);
            LinearLayout grid_item = myview.findViewById(R.id.grid_item);
            TextView grid_text = myview.findViewById(R.id.grid_text);

            HashMap <String,String> hashMap = arrayList.get(i);

            String cate = hashMap.get("cat");
            Cover_image.setImageResource(category[i]);

            if(cate == "sports")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Sports.class));
                    }
                });
            }

            if(cate == "naked")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Naked_Sports.class));
                    }
                });
            }

            if(cate == "cafe")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Cafe_Racer.class));
                    }
                });
            }
            if(cate == "adv")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, ADV.class));
                    }
                });
            }
            if(cate == "Cruiser")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Cruiser.class));
                    }
                });
            }
            if(cate == "offroad")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Off_Road.class));
                    }
                });
            }
            if(cate == "Commuter")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Commuter.class));
                    }
                });
            }

            if(cate == "Scooter")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Scooter.class));
                    }
                });
            }
            if(cate == "electric")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Category.this, Electric.class));
                    }
                });
            }

            return myview;
        }
    }
    private void CreateTable(){
        hashMap = new HashMap<>();
        hashMap.put("cat","sports");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","naked");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","cafe");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","adv");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Cruiser");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","offroad");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Commuter");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","Scooter");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","electric");
        arrayList.add(hashMap);


    }
}