package com.example.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.bakingapp.adapter.BakInAdapter;
import com.example.bakingapp.bean.Baking;

public class DetailsActivity extends BaseActivity {
    public static final String BAK = "BAK";
    private Baking baking;
    RecyclerView rlvI;
    BakInAdapter bakInAdapter;

    public static void start(Context context, Baking baking) {
        Intent starter = new Intent(context, DetailsActivity.class);
        starter.putExtra(BAK, baking);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        baking = getIntent().getParcelableExtra(BAK);
        rlvI = findViewById(R.id.rlv_i);
        bakInAdapter = new BakInAdapter(this, baking.getIngredients());
        rlvI.setAdapter(bakInAdapter);
    }
}