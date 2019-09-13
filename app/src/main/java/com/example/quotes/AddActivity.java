package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.quote) EditText mQuote;
    @BindView(R.id.author) EditText mAuthor;
    @BindView(R.id.addQuoteButton) Button mAddQuoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        mAddQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String author = mAuthor.getText().toString();
                String quote = mQuote.getText().toString();
                Intent addQuoteIntent = new Intent(AddActivity.this, ReadActivity.class);
                addQuoteIntent.putExtra("author", author);
                addQuoteIntent.putExtra("quote", quote);
                startActivity(addQuoteIntent);
            }
        });

    }
}
