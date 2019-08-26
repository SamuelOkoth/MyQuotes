package com.moringa.myquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;

import static java.lang.Math.E;

public class MainActivity extends AppCompatActivity {
    private Button mFindQuotesButton;
    private EditText mQuotesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuotesEditText = (EditText) findViewById(R.id.QuotesEditText);
        mFindQuotesButton = (Button) findViewById(R.id.FindQuotesButton);
        ButterKnife.bind(this);

        mFindQuotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome to The Quotes World", Toast.LENGTH_LONG).show();
                String location = mQuotesEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
                intent.putExtra("QuotesActivity", location);
                startActivity(intent);
            }
        });
    }

}
