package com.stocktwt.devininformation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

public class resume_activity extends AppCompatActivity {

    Button btnZoomIn;
    ImageView img1;
    Animation animationzoomin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resume);

        btnZoomIn = (Button)findViewById(R.id.btnZoomIN);
        img1 = (ImageView)findViewById(R.id.resume_imageview);


    }}

