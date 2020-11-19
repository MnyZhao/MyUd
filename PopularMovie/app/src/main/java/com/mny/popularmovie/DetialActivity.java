package com.mny.popularmovie;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mny.popularmovie.bean.Movies;
import com.mny.popularmovie.room.FavoriteDatabase;
import com.mny.popularmovie.room.MoviesDao;
import com.mny.popularmovie.utls.JavaHttpUrl;

import java.util.ArrayList;
import java.util.List;


public class DetialActivity extends BaseActivity {
    public static final String key = "key";
    private Movies movies;
    private ImageView ivImg;
    private TextView tvTitle;
    private TextView tvDate;
    private TextView tvScope;
    private TextView tvDesp;
    private TextView tvCollection;
    private MoviesDao moviesDao;
    private ViewPager2 vp2_params;
    private TabLayout tl_params;
    String[] title = {"Trailer", "Reviews"};
    List<Fragment> fragments = new ArrayList<>();
    public static void start(Context context, Movies movie) {
        Intent starter = new Intent(context, DetialActivity.class);
        starter.putExtra(key, movie);
        context.startActivity(starter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial_new);
        moviesDao = FavoriteDatabase.getInstance().userDao();
        setTitle("Movie Detail");
        showBack();
        movies = (Movies) getIntent().getParcelableExtra(key);
        vp2_params = findViewById(R.id.vp2_params);
        tl_params = findViewById(R.id.sliding_tabs);
        ivImg = findViewById(R.id.iv_img);
        tvTitle = findViewById(R.id.tv_title);
        tvDate = findViewById(R.id.tv_data);
        tvScope = findViewById(R.id.tv_scope);
        tvDesp = findViewById(R.id.tv_desp);
        tvCollection = findViewById(R.id.tv_collection);
        if (moviesDao.query(movies.getId()) > 0) {
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
                        if (setSp()) {
                            tvCollection.setBackgroundColor(Color.parseColor("#009688"));
                        } else {
                            tvCollection.setBackgroundColor(Color.parseColor("#aaaaaa"));
                        }

                    }
                }
        );
        fragments.add(TrailerFragment.newInstance(movies.getId()));
        fragments.add(ReviewsFragment.newInstance(movies.getId()));
        vp2_params.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return fragments.get(position);
            }

            @Override
            public int getItemCount() {
                return fragments.size();
            }
        });
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tl_params, vp2_params, new TabLayoutMediator.TabConfigurationStrategy() {

            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(title[position]);
            }
        }
        );
        tabLayoutMediator.attach();
    }

    public static final String KEYS = "movies";

    private boolean setSp() {
        int i = moviesDao.query(movies.getId());
        if (i > 0) {
            moviesDao.delete(movies.getId());
            return false;
        }
        moviesDao.insert(movies);
        return true;
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