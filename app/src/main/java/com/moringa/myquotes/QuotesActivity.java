package com.moringa.myquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class QuotesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        TextView mQuotesEditText = (TextView) findViewById(R.id.QuotesEditText);
        Intent intent = getIntent();
        String Quotes = intent.getStringExtra("Quotes");



        mQuotesEditText.setText("Here are all the available Quotes: " + Quotes);


    }
}
