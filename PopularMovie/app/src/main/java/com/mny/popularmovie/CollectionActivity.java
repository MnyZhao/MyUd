package com.mny.popularmovie;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.model.MovieViewModel;
import com.mny.popularmovie.room.FavoriteDatabase;
import com.mny.popularmovie.utls.RlvItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class CollectionActivity extends BaseActivity {
    private RecyclerView rlv;
    List<Movies> list = new ArrayList<>();
    private MvAdapter mvAdapter;
    private MovieViewModel viewModel;

    public static void start(Context context) {
        Intent starter = new Intent(context, CollectionActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        setTitle("My Favorite");
        showBack();
        rlv = findViewById(R.id.rlv_collection);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rlv.setLayoutManager(gridLayoutManager);
        mvAdapter = new MvAdapter(CollectionActivity.this, new RlvItemClickListener() {
            @Override
            public void onItemClickListener(Movies movies) {
                DetialActivity.start(CollectionActivity.this, movies);
            }
        });
        rlv.setAdapter(mvAdapter);
        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        viewModel.getMovieLiveData().observe(this, new Observer<List<Movies>>() {
            @Override
            public void onChanged(List<Movies> movies) {
                mvAdapter.addData(movies);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:   //返回键的id
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}