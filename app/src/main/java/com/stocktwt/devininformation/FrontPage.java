package com.stocktwt.devininformation;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FrontPage extends AppCompatActivity implements View.OnClickListener,Animation.AnimationListener
{
    Button bsimple, btough, bseeotherapps, brateapp;
    private Animation translateAnim;
    private Animation translateright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        //animation start
       ImageView athleteFrame = (ImageView) findViewById(R.id.imageFrame);
       ImageView twitterbirdright = (ImageView)findViewById(R.id.imageFrame2);
        athleteFrame.setBackgroundResource(R.drawable.frame);
        twitterbirdright.setBackgroundResource(R.drawable.frameright);
       AnimationDrawable frameAnimation = (AnimationDrawable) athleteFrame.getBackground();
       AnimationDrawable frameright = (AnimationDrawable) twitterbirdright.getBackground();
        if (frameAnimation.isRunning()) {
            frameAnimation.stop();
        } else {
            frameAnimation.stop();
            frameAnimation.start();
        }
        if (frameright.isRunning()) {
            frameright.stop();
        } else {
            frameright.stop();
            frameright.start();
        }
        translateAnim = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        athleteFrame.startAnimation(translateAnim);
        translateAnim.setAnimationListener(this);
        translateright = AnimationUtils.loadAnimation(this, R.anim.translate_anim2);
        translateright.setAnimationListener(this);
        twitterbirdright.startAnimation(translateright);
        //animation end

        //codes to add title bar
       LinearLayout front_ll = (LinearLayout)findViewById(R.id.frontpage_titlebar);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.frontpage_title_bar);
        //setting action bar text
        TextView tv_category = (TextView)findViewById(R.id.tvfrontpage_titlebar);
        tv_category.setText("Devin Burke");

        //button and listener set-ups
        bsimple = (Button)findViewById(R.id.bsq);
        btough = (Button)findViewById(R.id.btq);
        bseeotherapps = (Button)findViewById(R.id.other);
        brateapp = (Button)findViewById(R.id.rate);
        bsimple.setOnClickListener(FrontPage.this);
        btough.setOnClickListener(FrontPage.this);
        bseeotherapps.setOnClickListener(FrontPage.this);
        brateapp.setOnClickListener(FrontPage.this);
    } //end of onCreate
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.bsq:
                Intent i = new Intent(FrontPage.this, simple_question.class);
                startActivity(i);
                overridePendingTransition(R.anim.in, R.anim.out);
                break;
            case R.id.btq:
                Intent j = new Intent(FrontPage.this, resume_activity.class);
                startActivity(j);
                break;
            case R.id.other:
                try {
                    Uri uril = Uri.parse("market://search?q=devinburke");
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uril);
                    startActivity(goToMarket1);
                }catch(ActivityNotFoundException e){
                    Uri uril = Uri.parse("http://play.google.com/store/search/?q=XXX");
                    Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uril);
                    startActivity(goToMarket1);
                }
                break;
            case R.id.rate:
               try {
                   Uri uril = Uri.parse("market://details?id=" + getPackageName());
                   Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uril);
                   startActivity(goToMarket1);
               }catch(ActivityNotFoundException e){
                   Uri uril = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                   Intent goToMarket1 = new Intent(Intent.ACTION_VIEW, uril);
                   startActivity(goToMarket1);
               }
                   break;
        }//end of switch

    }//end of onClick

    @Override
    public void onAnimationEnd(Animation animation) {
        TextView welcome = (TextView)findViewById(R.id.welcome);
        welcome.setText("Welcome");
    }
    @Override
    public void onAnimationStart(Animation animation) {
    }
    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}//end of main function (FrontPage)
