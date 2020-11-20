package com.example.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;

import com.example.bakingapp.adapter.BakListAdapter;
import com.example.bakingapp.adapter.ItemClickListener;
import com.example.bakingapp.bean.Baking;
import com.example.bakingapp.utils.JsonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    RecyclerView rlv;
    BakListAdapter bakListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = findViewById(R.id.rlv_bak_list);
        List<Baking> bakingList = JsonUtils.getBankings(JsonUtils.info);
        bakListAdapter = new BakListAdapter(this, bakingList, clickListener);
        rlv.setAdapter(bakListAdapter);
    }

    ItemClickListener clickListener = new ItemClickListener() {
        @Override
        public void onClick(Baking baking) {
            DetailsActivity.start(MainActivity.this, baking);
        }
    };
}