package com.mny.popularmovie;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mny.popularmovie.utls.MovieJsonUtils;
import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.utls.JavaHttpUrl;
import com.mny.popularmovie.utls.RlvItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private final int LOADINGOVER = 1001;
    private RecyclerView rlv;
    private MvAdapter mvAdapter;
    private List<Movies> list = new ArrayList<>();
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOADINGOVER:
                    String m = (String) msg.obj;
                    if (!TextUtils.isEmpty(m)) {
                        List<Movies> mlist = MovieJsonUtils.getMovies(m);
                        list.clear();
                        list.addAll(mlist);
                        mvAdapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MainActivity.this, "movie is null", Toast.LENGTH_SHORT).show();
                    }
                    pgDialog.dismiss();
                    break;
            }
        }
    };
    ProgressDialog pgDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = findViewById(R.id.rlv);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rlv.setLayoutManager(gridLayoutManager);
        mvAdapter = new MvAdapter(list, MainActivity.this, new RlvItemClickListener() {
            @Override
            public void onItemClickListener(Movies movies) {
                DetialActivity.start(MainActivity.this, movies);
            }
        });
        rlv.setAdapter(mvAdapter);
        loadMovie(this, Config.HTTP_POPULAR);
    }

    private void loadMovie(Context context, final String url) {
        pgDialog = ProgressDialog.show(context, "Tip", "Loading...wait", false);
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        String movies = JavaHttpUrl.getInfo(url);
                        Message msg = handler.obtainMessage();
                        msg.what = LOADINGOVER;
                        msg.obj = movies;
                        handler.sendMessage(msg);
                    }
                }
        ).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.popular:
                loadMovie(MainActivity.this, Config.HTTP_POPULAR);
                break;
            case R.id.top_rated:
                loadMovie(MainActivity.this, Config.HTTP_TOP);
                break;
            case R.id.collection:
                CollectionActivity.start(MainActivity.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}