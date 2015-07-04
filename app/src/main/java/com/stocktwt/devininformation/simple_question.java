package com.stocktwt.devininformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class simple_question extends AppCompatActivity implements View.OnClickListener {
    TextView tvquestion, tvanswer, tvtotallenth_yy, tvpresentindex_xx;
    Button bleft, bright, bshow, bback;
    String[] simple_questions, simple_answers;
    int index;
    private static final String default_answer = "Press Blue Button to display skills or press next";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        //codes to add title bar
        LinearLayout questions_ll = (LinearLayout)findViewById(R.id.questions_titlebar);
        getSupportActionBar().setDisplayOptions(android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.questions_title_bar);
        //creates action bar title text
        TextView tv_category = (TextView)findViewById(R.id.tvquestion_title);
        tv_category.setText("Skill and Information");

        //importing string array from values folders, xml
        simple_questions = getResources().getStringArray(R.array.simple_question);
        simple_answers = getResources().getStringArray(R.array.simple_answer);
        //Initialization of textviews and buttons
        tvanswer = (TextView)findViewById(R.id.tvanswer);
        tvquestion = (TextView)findViewById(R.id.tvquestion);
        tvtotallenth_yy = (TextView)findViewById(R.id.tvyy);
        tvpresentindex_xx = (TextView)findViewById(R.id.tvxx);
        bleft = (Button)findViewById(R.id.bleft);
        bright = (Button)findViewById(R.id.bright);
        bshow = (Button)findViewById(R.id.showanswer);
        bback = (Button)findViewById(R.id.back);

        //setting up onClick listener for buttons, also speak and mute buttons
        bleft.setOnClickListener(this);
        bright.setOnClickListener(this);
        bshow.setOnClickListener(this);
        bback.setOnClickListener(this);

        //setting up textview texts and index
        index = 0;
        tvquestion.setText(simple_questions[index]);
        tvanswer.setText(default_answer);
        tvpresentindex_xx.setText(String.valueOf(index+1));
        tvtotallenth_yy.setText("/"+String.valueOf(simple_questions.length));
    }//end of onCreate
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bleft:
                tvanswer.setText(default_answer);
                index--;
                if(index==-1){ // allows for circular array
                    index = simple_questions.length-1;
                    tvquestion.setText(simple_questions[index]);
                    tvpresentindex_xx.setText(String.valueOf(index+1));
                }
                else{
                tvquestion.setText(simple_questions[index]);
                tvpresentindex_xx.setText(String.valueOf(index+1));
                }
                break;
            case R.id.bright:
                tvanswer.setText(default_answer);
                index++;
                if(index == simple_questions.length){
                    index = 0; // allows for circular array
                    tvquestion.setText(simple_questions[index]);
                    tvpresentindex_xx.setText(String.valueOf(index+1));}
                else {
                    tvquestion.setText(simple_questions[index]);
                    tvpresentindex_xx.setText(String.valueOf(index + 1));}
                break;
            case R.id.showanswer:
                tvanswer.setText(simple_answers[index]);
                break;
            case R.id.back:
                Intent x = new Intent(simple_question.this, FrontPage.class);
                startActivity(x);
                overridePendingTransition(R.anim.in, R.anim.out);
                break;
        } // ends switch
    } // ends onclick

}//end main function (simple_question)

