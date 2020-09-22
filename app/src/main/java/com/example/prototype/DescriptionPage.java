package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DescriptionPage extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    String vidid;
    String type;
    String channel;
    String title;
    String description;
    TextView name,channelName,Description,TypeOFvideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description_page);
        youTubePlayerView=(YouTubePlayerView)findViewById(R.id.preview);
        Intent intent=getIntent();
        vidid=intent.getStringExtra("youtubeId");
        type=intent.getStringExtra("type");
        channel=intent.getStringExtra("channel");
        title=intent.getStringExtra("title");
        description=intent.getStringExtra("Description");


        name=findViewById(R.id.descriptionTitle);
        channelName=findViewById(R.id.nameofchannelDescription);
        Description=findViewById(R.id.descriptionText);
        TypeOFvideo=findViewById(R.id.videoType);


        name.setText(title);
        Description.setText(description);
        channelName.setText(channel);
        TypeOFvideo.setText("Type: "+type);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(type.equals("playlist"))
                    youTubePlayer.loadPlaylist(vidid);
                else
                    youTubePlayer.loadVideo(vidid);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize("AIzaSyCbga5PXf_4cCwwqFqMSCbbwepRa7xxzGs",onInitializedListener);
    }
}
