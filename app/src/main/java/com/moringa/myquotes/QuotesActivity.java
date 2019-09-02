package com.moringa.myquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.AdapterView;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class QuotesActivity extends AppCompatActivity  {
 @BindView(R.id.QuotesEditText)TextView mTextview;
 @BindView(R.id.listView)ListView mListview;

    private String[] Quotes = new String[] {"I've learned to ignore the negative people and just be a living example of confidence and self-love "
             , "Corgito Ergo Sum ",
            "Life is an Dream ", "Every Dog has its day","Diversity is what makes life interesting.","My mission in life is not merely to survive, but to thrive; and to do so with some passion, some compassion, some humor, and some style."

             };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Quotes);
        mListview.setAdapter(adapter);

        TextView mQuotesEditText = (TextView) findViewById(R.id.QuotesEditText);
        Intent intent = getIntent();
        String Quotes = intent.getStringExtra("Quotes");





        mQuotesEditText.setText("Here are all the available Quotes: " + Quotes);


    }
    private void getQuotes(String Quotes) throws IOException {
        final QuoteService quoteService = new QuoteService();
        quoteService.findQuotes(Quotes, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException  {



            }
        });
    }
}
