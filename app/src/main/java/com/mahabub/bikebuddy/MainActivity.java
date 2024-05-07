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
    HashMap <String,String> hashMap1 = new HashMap<>();

    public int CatCover[] = {R.drawable.yamaha,R.drawable.honda,R.drawable.suzukii,R.drawable.tvs,R.drawable.gpx,R.drawable.more};
    public int BrCover[] = {R.drawable.sprots,R.drawable.nakedsp,R.drawable.cafe_racer,R.drawable.cruizer,R.drawable.advanture,R.drawable.more};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    slider();                ///On Create Bundle is here................................................

        gridView = findViewById(R.id.GridView);
        gridView1 = findViewById(R.id.GridView1);

        CreateTable();
        CreateTable1();
        MyAdapter adapter = new MyAdapter();
        gridView.setAdapter(adapter);
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
            Cover_image.setImageResource(BrCover[i]);

            if(cate == "more")
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
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","nsports");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","cafe");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","cruizer");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","adv");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("cat","more");
        arrayList.add(hashMap);

    }

    public void slider(){
        //===============================================
        ImageSlider imageSlider;
        imageSlider =findViewById(R.id.image_slider);
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel("https://imgd.aeplcdn.com/1280x720/n/cw/ec/145871/yamaha-r15-right-side-view1.jpeg", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://www.gpxmalaysia.my/wp-content/uploads/2020/06/gpx-demon-gr200r-colour-matt-gray.jpg", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://moto7.net/imgs/230116-HONDA-CBR250RR-JAPAN-4.jpg",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://i.ndtvimg.com/i/2016-10/2017-ktm-rc-390-new-colours_827x510_61476368941.jpg",ScaleTypes.CENTER_CROP));

        imageSlider.setImageList(imageList);
        //===============================================
    }
}