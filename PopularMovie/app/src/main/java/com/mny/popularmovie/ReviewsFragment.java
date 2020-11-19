package com.mny.popularmovie;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mny.popularmovie.adapter.RewAdapter;
import com.mny.popularmovie.bean.MoviesReviews;
import com.mny.popularmovie.utls.JavaHttpUrl;
import com.mny.popularmovie.utls.MovieJsonUtils;


public class ReviewsFragment extends Fragment {

    String TAG = this.getClass().getName();
    private static final String ARG_PARAM1 = "id";
    RecyclerView rlv;
    private String id;
    RewAdapter rewAdapter;

    public ReviewsFragment() {
    }

    public static ReviewsFragment newInstance(String id) {
        ReviewsFragment fragment = new ReviewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_review, container, false);
        rlv = view.findViewById(R.id.rlv_re);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadReviews(requireActivity(), Config.getReviewUrl(id));
        rewAdapter = new RewAdapter();
        rlv.setAdapter(rewAdapter);
    }

    private final int LOADINGOVER = 1002;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOADINGOVER:
                    String m = (String) msg.obj;
                    Log.i(TAG, m);
                    if (!TextUtils.isEmpty(m)) {
                        MoviesReviews reviews = MovieJsonUtils.getReviews(m);
                        rewAdapter.addData(reviews.getResults());
                    } else {
                        Toast.makeText(requireActivity(), "Reviews is null", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    private void loadReviews(Context context, final String url) {
        Log.i(TAG, "# loadReviews");
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        String videos = JavaHttpUrl.getInfo(url);
                        Message msg = handler.obtainMessage();
                        msg.what = LOADINGOVER;
                        msg.obj = videos;
                        handler.sendMessage(msg);
                    }
                }
        ).start();
    }
}