package com.mny.popularmovie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import com.mny.popularmovie.adapter.VideoAdapter;
import com.mny.popularmovie.bean.MoviesViedo;
import com.mny.popularmovie.interfac.ItemClickListener;
import com.mny.popularmovie.utls.JavaHttpUrl;
import com.mny.popularmovie.utls.MovieJsonUtils;


public class TrailerFragment extends Fragment {

    String TAG = TrailerFragment.class.getName();
    private static final String ARG_PARAM1 = "id";

    private String id;
    private RecyclerView rlv;
    private VideoAdapter vAdapter;

    public TrailerFragment() {
    }

    public static TrailerFragment newInstance(String id) {
        TrailerFragment fragment = new TrailerFragment();
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
        Log.i(TAG, "# onCreateView");
        return inflater.inflate(R.layout.fragment_trailer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "# onViewCreated");
        rlv = view.findViewById(R.id.rlv_t);
        vAdapter = new VideoAdapter();
        vAdapter.setOnClickListener(new ItemClickListener() {
            @Override
            public void onClick(String playMovie) {
                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(playMovie)
                );
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        rlv.setAdapter(vAdapter);
        loadMovie(requireActivity(), Config.getVideoUrl(id));
    }

    @Override
    public void onResume() {
        Log.i(TAG, "# onResume");
        super.onResume();
    }

    private final int LOADINGOVER = 1002;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case LOADINGOVER:
                    String m = (String) msg.obj;
                    if (!TextUtils.isEmpty(m)) {
                        MoviesViedo video = MovieJsonUtils.getVideo(m);
                        vAdapter.addData(video.getResults());
                    } else {
                        Toast.makeText(requireActivity(), "movie is null", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    private void loadMovie(Context context, final String url) {
        Log.i(TAG, "# loadMovie");
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