package com.learn.binod.technoriochallenge.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learn.binod.technoriochallenge.MainActivity;
import com.learn.binod.technoriochallenge.R;

public class Starter extends AppCompatActivity {
    private Button Btnposts,Btntags;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);


       Btnposts=(Button)findViewById(R.id.btnPosts);
        Btntags=(Button)findViewById(R.id.btnTags);

    Btnposts.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Starter.this,MainActivity.class);
            startActivity(intent);
        }
    });

        Btntags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
