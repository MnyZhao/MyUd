package com.mny.popularmovie;

import androidx.annotation.NonNull;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.utls.JavaHttpUrl;
import com.mny.popularmovie.utls.Json;
import com.mny.popularmovie.utls.SpUtils;

import org.json.JSONException;


public class DetialActivity extends BaseActivity {
    public static final String key = "key";
    private Movies movies;
    private ImageView ivImg;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvScope;
    private TextView tvDesp;
    private TextView tvCollection;

    public static void start(Context context, Movies movie) {
        Intent starter = new Intent(context, DetialActivity.class);
        starter.putExtra(key, movie);
        context.startActivity(starter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);
        setTitle("Movie Detail");
        showBack();
        movies = (Movies) getIntent().getParcelableExtra(key);
        ivImg = findViewById(R.id.iv_img);
        tvTitle = findViewById(R.id.tv_title);
        tvDate = findViewById(R.id.tv_data);
        tvScope = findViewById(R.id.tv_scope);
        tvDesp = findViewById(R.id.tv_desp);
        tvCollection = findViewById(R.id.tv_collection);
        if (SpUtils.getString(this, KEYS, "").contains(movies.id)) {
            tvCollection.setBackgroundColor(Color.parseColor("#009688"));
        } else {
            tvCollection.setBackgroundColor(Color.parseColor("#aaaaaa"));
        }
        Glide.with(this).load(Config.BASE_IMG + movies.getPoster_path()).centerCrop().into(ivImg);
        tvTitle.setText(movies.getTitle());
        tvDate.setText(movies.getRelease_date());
        tvScope.setText(movies.getVote_average() + "/10");
        tvDesp.setText(movies.getOverview());
        tvCollection.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            String jsMovie = Json.toJson(movies);
                            if (setSp(jsMovie)) {
                                tvCollection.setBackgroundColor(Color.parseColor("#009688"));
                            } else {
                                tvCollection.setBackgroundColor(Color.parseColor("#aaaaaa"));
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        JavaHttpUrl.getInfo(Config.getVideosUrl(movies.id));
                    }
                }
        ).start();
    }

    public static final String KEYS = "movies";

    private boolean setSp(String jsMovie) {
        String s = SpUtils.getString(DetialActivity.this, KEYS, "");
        String updateInfo = "";
        boolean isCollection;
        if (s.contains(jsMovie + "|")) {
            updateInfo = s.replace((jsMovie + "|"), "");
            isCollection = false;
        } else {
            isCollection = true;
            updateInfo = s + (jsMovie + "|");
        }
        SpUtils.putString(DetialActivity.this, KEYS, updateInfo);
        return isCollection;
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