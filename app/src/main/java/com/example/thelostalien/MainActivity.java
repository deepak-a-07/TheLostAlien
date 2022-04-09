package com.example.thelostalien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    ImageButton ibStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // get rid of tool bar and set fullscreen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // get rid of toolbar

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Constants.SCREEN_WIDTH = dm.widthPixels;
        Constants.SCREEN_HEIGHT = dm.heightPixels;

        setContentView(R.layout.activity_main);


        MainActivity.mediaPlayer = MediaPlayer.create(this,R.raw.music);
        if(MainActivity.mediaPlayer != null) {
            MainActivity.mediaPlayer.setLooping(true);
            MainActivity.mediaPlayer.start();
        }

        ibStartGame = findViewById(R.id.ibStartGame);
        ibStartGame.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GamePanel.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(MainActivity.mediaPlayer != null) {
            MainActivity.mediaPlayer.stop();
            MainActivity.mediaPlayer.release();
            MainActivity.mediaPlayer = null;
        }
        super.onBackPressed();
    }
}