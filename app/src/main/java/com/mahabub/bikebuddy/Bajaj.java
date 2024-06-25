package com.mahabub.bikebuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Bajaj extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;
    ArrayList<HashMap<String, String >> arrayList = new ArrayList<>();
    HashMap < String, String > hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajaj);

        progressBar = findViewById(R.id.progressbar);
        listView = findViewById(R.id.list_view);
        String hit = "https://mmahabub.000webhostapp.com/project/bajaj.php";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, hit, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);

                for (int i=0; i<response.length(); i++)
                {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String brand = jsonObject.getString("brand");
                        String type = jsonObject.getString("type");
                        String engine = jsonObject.getString("engine");
                        String output = jsonObject.getString("output");
                        String milage = jsonObject.getString("milage");
                        String tire = jsonObject.getString("tire");
                        String abs = jsonObject.getString("abs");
                        String price = jsonObject.getString("price");
                        String speed = jsonObject.getString("speed");
                        String img = jsonObject.getString("img"); ///

                        hashMap = new HashMap<>();
                        hashMap.put("id", id);
                        hashMap.put("name", name);
                        hashMap.put("brand", brand);
                        hashMap.put("type", type);
                        hashMap.put("engine", engine);
                        hashMap.put("output", output);
                        hashMap.put("milage", milage);
                        hashMap.put("tire", tire);
                        hashMap.put("abs", abs);
                        hashMap.put("price", price);
                        hashMap.put("speed", speed);
                        hashMap.put("img", img);///
                        arrayList.add(hashMap);

                        Myadapter myadapter = new Myadapter();
                        listView.setAdapter(myadapter);

                    }
                    catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(Bajaj.this);
        requestQueue.add(jsonArrayRequest);


    }

    public class Myadapter extends BaseAdapter {

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
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.itemz,null);

            ImageView image = myView.findViewById(R.id.img);
            TextView name = myView.findViewById(R.id.name);
            TextView engine = myView.findViewById(R.id.engine);
            TextView output = myView.findViewById(R.id.output);
            TextView price = myView.findViewById(R.id.price);
            LinearLayout list_item = myView.findViewById(R.id.list_item);




            hashMap = arrayList.get(position);
            String id = hashMap.get("id");
            String img = (hashMap.get("img"));
            name.setText(hashMap.get("name"));
            engine.setText(hashMap.get("engine"));
            output.setText(hashMap.get("output"));
            price.setText(hashMap.get("price") + " BDT");

            Picasso.get().load(img).placeholder(R.drawable.kawasaki).into(image);

            list_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openActivity(position);
                }
            });

            return myView;
        }
    }

    public void openActivity(int pos){

        hashMap = arrayList.get(pos);
        String id = hashMap.get("id");
        String name = hashMap.get("name");
        String brand = hashMap.get("brand");
        String type = hashMap.get("type");
        String engine = hashMap.get("engine");
        String output = hashMap.get("output");
        String milage = hashMap.get("milage");
        String tire = hashMap.get("tire");
        String abs = hashMap.get("abs");
        String price = hashMap.get("price");
        String speed = hashMap.get("speed");
        String img = hashMap.get("img");

        Intent intent = new Intent(Bajaj.this,Details.class);
        intent.putExtra("id",id);
        intent.putExtra("name",name);
        intent.putExtra("brand", brand);
        intent.putExtra("type",type);
        intent.putExtra("engine",engine);
        intent.putExtra("output",output);
        intent.putExtra("milage",milage);
        intent.putExtra("tire",tire);
        intent.putExtra("abs",abs);
        intent.putExtra("price",price);
        intent.putExtra("speed",speed);
        intent.putExtra("img",img);

        startActivity(intent);
    }



}