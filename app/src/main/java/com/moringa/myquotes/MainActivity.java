package com.moringa.myquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mFindQuotesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFindQuotesButton = (Button) findViewById(R.id.FindQuotesButton);
        mFindQuotesButton = (Button) findViewById(R.id.FindQuotesButton);
        mFindQuotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome to The Quotes World", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
                startActivity(intent);
            }
        });
    }

}
