package com.dipakkr.github.moviesapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dipakkr.github.moviesapi.R;

/**
 * Created by root on 6/24/17.
 */

public class SplashActivity extends AppCompatActivity {

    Animation zoomIn ,slide_down;
    TextView txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = (ImageView)findViewById(R.id.img_movie);
        txt = (TextView)findViewById(R.id.txt);

        zoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        slide_down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);

        txt.setVisibility(View.VISIBLE);
        txt.setAnimation(zoomIn);

        imageView.setVisibility(View.VISIBLE);
        imageView.setAnimation(slide_down);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startActivity(new Intent(SplashActivity.this,Authentication.class));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

