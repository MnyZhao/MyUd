package com.example.bakingapp;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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