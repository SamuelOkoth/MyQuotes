package com.moringa.myquotes;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class PicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
    }

    public void radioClick(View view) {
       ImageView image = (ImageView) findViewById(R.id.images);
        int id = view.getId();
        if(id == R.id.easyButton){
            image.setImageResource(R.drawable.easy);
        }else if(id == R.id.outButton){
            image.setImageResource(R.drawable.out);
        } else if(id == R.id.semiButton){
            image.setImageResource(R.drawable.semi);
        }else if(id == R.id.teamButton){
            image.setImageResource(R.drawable.team);
        }

    }
}
