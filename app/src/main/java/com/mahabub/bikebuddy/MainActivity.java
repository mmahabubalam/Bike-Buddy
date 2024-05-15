package com.mahabub.bikebuddy;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    GridView gridView,gridView1;
    ArrayList < HashMap <String,String> > arrayList = new ArrayList<>();
    ArrayList < HashMap <String,String> > arrayList1 = new ArrayList<>();
    HashMap <String,String> hashMap = new HashMap<>();


    public int CatCover[] = {R.drawable.yamaha,R.drawable.honda,R.drawable.suzukii,R.drawable.tvs,R.drawable.benili,R.drawable.more};
    public int BrCover[] = {R.drawable.sprots,R.drawable.nakedsp,R.drawable.cafe_racer,R.drawable.cruizer,R.drawable.advanture,R.drawable.more};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    slider();                ///On Create Bundle is here................................................

        gridView = findViewById(R.id.GridView);
        gridView1 = findViewById(R.id.GridView1);


        CreateTable();
        MyAdapter adapter = new MyAdapter();
        gridView.setAdapter(adapter);

        CreateTable1();
        MyAdapter1 adapter1 = new MyAdapter1();
        gridView1.setAdapter(adapter1);




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

            String brand = hashMap.get("brand");
            Cover_image.setImageResource(CatCover[i]);

            if(brand == "More")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, All_Brands.class));
                    }
                });
            }

            return myview;
        }
    }

    public class MyAdapter1 extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList1.size();
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

            HashMap <String,String> hashMap = arrayList1.get(i);

            String brand = hashMap.get("cat");
            Cover_image.setImageResource(BrCover[i]);

            if(brand == "more")
            {
                grid_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, All_Category.class));
                    }
                });
            }

            return myview;
        }
    }


    private void CreateTable(){
        hashMap = new HashMap<>();
        hashMap.put("brand","yamaha");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("brand","honda");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("brand","suzuki");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("brand","tvs");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("brand","gpx");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("brand","More");
        arrayList.add(hashMap);

    }
    private void CreateTable1(){

        hashMap = new HashMap<>();
        hashMap.put("cat","sports");
        arrayList1.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","nsports");
        arrayList1.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","cafe");
        arrayList1.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","cruizer");
        arrayList1.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","adv");
        arrayList1.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","more");
        arrayList1.add(hashMap);

    }

    public void slider(){
        //===============================================
        ImageSlider imageSlider;
        imageSlider =findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel("https://www.ducatimelbourne.com.au/media/catalog/product/p/a/panigalev4r2023_1.jpg", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://cdn2.yamaha-motor.eu/prod/product-assets/2024/YZF600R6RCOMP/2024-Yamaha-YZF600R6RCOMP-EU-Tech_Black-Studio-001-03.jpg", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://images5.1000ps.net/images_bikekat/2024/4-Yamaha/329-R1/010-638352168675017932-yamaha-r1.jpg",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://cache3.pakwheels.com/system/bike_model_pictures/2023/original/Bmw-new.jpg?1688727690",ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imageList);
        //===============================================
    }
}