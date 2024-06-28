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

public class Nearby_Service extends AppCompatActivity {

    ProgressBar progressBar;
    ListView listView;
    ArrayList<HashMap<String, String >> arrayList = new ArrayList<>();
    HashMap < String, String > hashMap;
    EditText fuel;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_service);

        progressBar = findViewById(R.id.progressbar);
        listView = findViewById(R.id.list_view);
        fuel = findViewById(R.id.fuel);
        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hit = "https://mmahabub.000webhostapp.com/project/service.php?shop=" + fuel.getText().toString();
                Load_Data(hit);
            }
        });
    }

    public int Load_Data(String url){
        progressBar.setVisibility(View.VISIBLE);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);

                // Clear the existing data before adding new data
                arrayList.clear();

                for (int i=0; i<response.length(); i++)
                {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String area = jsonObject.getString("area");
                        String address = jsonObject.getString("address");
                        String number = jsonObject.getString("number");
                        String status = jsonObject.getString("status");
                        String shop = jsonObject.getString("shop");

                        hashMap = new HashMap<>();
                        hashMap.put("id", id);
                        hashMap.put("name", name);
                        hashMap.put("area", area);
                        hashMap.put("address", address);
                        hashMap.put("number", number);
                        hashMap.put("status", status);
                        hashMap.put("shop", shop);
                        arrayList.add(hashMap);
                    }
                    catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }

                // Notify the adapter that the data has changed
                Myadapter myadapter = new Myadapter();
                listView.setAdapter(myadapter);
                myadapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(Nearby_Service.this);
        requestQueue.add(jsonArrayRequest);
        return 0;
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
            View myView = layoutInflater.inflate(R.layout.lists,null);

            TextView name = myView.findViewById(R.id.sname);
            TextView address = myView.findViewById(R.id.saddress);
            TextView status = myView.findViewById(R.id.sstatus);
            LinearLayout list_item = myView.findViewById(R.id.list_item);

            hashMap = arrayList.get(position);
            String id = hashMap.get("id");
            name.setText(hashMap.get("name"));
            address.setText(hashMap.get("address"));
            status.setText(hashMap.get("status"));

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
        String area = hashMap.get("area");
        String address = hashMap.get("address");
        String number = hashMap.get("number");
        String status = hashMap.get("status");

        Intent intent = new Intent(Nearby_Service.this, Nearby_Details.class);
        intent.putExtra("id", id);
        intent.putExtra("name", name);
        intent.putExtra("area", area);
        intent.putExtra("address", address);
        intent.putExtra("number", number);
        intent.putExtra("status", status);

        startActivity(intent);
    }
}
