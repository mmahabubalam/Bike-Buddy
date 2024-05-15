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

public class All_Brands extends AppCompatActivity {

    GridView gridView;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap<>();

    public int brandcover[] = {R.drawable.yamaha,R.drawable.honda,R.drawable.suzuki,R.drawable.kawasaki,R.drawable.hero,R.drawable.tvs,
            R.drawable.bajaj, R.drawable.gpx, R.drawable.aprilia,R.drawable.ktm, R.drawable.benili, R.drawable.roadmaster,R.drawable.zontes, R.drawable.fkm, R.drawable.runner,
            R.drawable.hpower, R.drawable.lifan, R.drawable.taro,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_brands);

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

            String brand = hashMap.get("name");
            Cover_image.setImageResource(brandcover[i]);

            if(brand == "yamaha")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(All_Brands.this, Yamaha.class));
                    }
                });
            }

            return myview;
        }
    }
    private void CreateTable(){
        hashMap = new HashMap<>();
        hashMap.put("name","yamaha");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","honda");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","suzuki");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","tvs");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","benili");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","aprilia");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","gpx");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","hero");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ktm");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","bajaj");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","lifan");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","roadmaster");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","runner");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","taro");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","zontes");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","kawasaki");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","hpower");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","fkm");
        arrayList.add(hashMap);

    }

}