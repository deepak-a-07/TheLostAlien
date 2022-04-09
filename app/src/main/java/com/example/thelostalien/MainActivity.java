package com.example.thelostalien;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    ImageButton ibStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.mediaPlayer = MediaPlayer.create(this,R.raw.music);
        if(MainActivity.mediaPlayer != null) {
            MainActivity.mediaPlayer.setLooping(true);
            MainActivity.mediaPlayer.start();
        }
    }
}