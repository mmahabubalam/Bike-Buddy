package com.mahabub.bikebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

            String brand = hashMap.get("name");
            Cover_image.setImageResource(category[i]);


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
        hashMap.put("cat","cruizer");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","dirt");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","standard");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","scooty");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","electric");
        arrayList.add(hashMap);


    }
}