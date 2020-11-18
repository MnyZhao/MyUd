package com.mny.popularmovie;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.utls.JavaHttpUrl;
import com.mny.popularmovie.utls.MovieJsonUtils;
import com.mny.popularmovie.utls.RlvItemClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BaseActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
    }

    public void showBack() {
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void hideBack() {
        actionBar.setDisplayHomeAsUpEnabled(false);
    }

    public void setTitle(String title) {
        actionBar.setTitle(title);
    }

    public void setTitle(int id) {
        actionBar.setTitle(id);
    }

}