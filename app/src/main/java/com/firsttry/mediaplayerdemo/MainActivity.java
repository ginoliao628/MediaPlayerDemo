package com.firsttry.mediaplayerdemo;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import static android.content.Context.AUDIO_SERVICE;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mySound1;
    MediaPlayer mySound2;
    MediaPlayer mySound3;
    MediaPlayer mySound4;
    MediaPlayer mySound5;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySound1 = MediaPlayer.create(this, R.raw.a100);
        mySound2 = MediaPlayer.create(this, R.raw.a250);
        mySound3 = MediaPlayer.create(this, R.raw.a440);
        mySound4 = MediaPlayer.create(this, R.raw.a1k);
        mySound5 = MediaPlayer.create(this, R.raw.a10k);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar volControl = (SeekBar)findViewById(R.id.volbar);
        volControl.setMax(maxVolume);
        volControl.setProgress(curVolume);
        volControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, arg1, 0);
            }
        });


    }

    public void playMusic100(View view) {
        mySound1.seekTo(3000);
        mySound1.start();
    }

    public void playMusic250(View view) {
        mySound2.seekTo(3000);
        mySound2.start();
    }
    public void playMusic440(View view) {
        mySound3.seekTo(3000);
        mySound3.start();
    }
    public void playMusic1k(View view) {
        mySound4.seekTo(3000);
        mySound4.start();
    }
    public void playMusic10k(View view) {
        mySound5.seekTo(3000);
        mySound5.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
