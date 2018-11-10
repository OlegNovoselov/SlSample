package com.makeomatic.slsample;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    static private final String DEVELOPER_KEY = "AIzaSyAPS8hibYB7lXKpKf8QVwAZ7tb5wsvlar8";
    static private final String VIDEO = "oXmN-JuKDN4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(DEVELOPER_KEY, this);

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
        Toast.makeText(this, "Блин!" + error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        player.loadVideo(VIDEO);
        player.play();
    }
}
