package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class youtubeplayerview extends YouTubeBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtubeplayerview);

//        Intent intent=getIntent();
//        vidid=intent.getStringExtra("youtubeId");
//        type=intent.getStringExtra("type");
//        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                if(type.equals("playlist"))
//                    youTubePlayer.loadPlaylist(vidid);
//                else
//                    youTubePlayer.loadVideo(vidid);
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };
//        youTubePlayerView.initialize("AIzaSyCbga5PXf_4cCwwqFqMSCbbwepRa7xxzGs",onInitializedListener);
    }
}
