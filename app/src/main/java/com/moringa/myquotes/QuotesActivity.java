package com.moringa.myquotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.moringa.myquotes.services.QuoteService;
import com.moringa.myquotes.services.RetrofitInstance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.internal.cache.CacheRequest;

public class QuotesActivity extends AppCompatActivity  {
    public static final String TAG = QuotesActivity.class.getSimpleName();


 @BindView(R.id.QuotesTextView) TextView mTextview;
 @BindView(R.id.listView) ListView mListview;
// @BindView(R.id.recyclerView)
//    RecyclerView mRecyclerView;
    private QuotesListAdapter mAdapter;

//    private String[] Quotes = new String[] {"I've learned to ignore the negative people and just be a living example of confidence and self-love "
//             , "Corgito Ergo Sum ",
//            "Life is an Dream ", "Every Dog has its day","Diversity is what makes life interesting.","My mission in life is not merely to survive, but to thrive; and to do so with some passion, some compassion, some humor, and some style."
//
//             };
        public ArrayList<Quotes> mQuotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        ButterKnife.bind(this);

        TextView mQuotesEditText = (TextView) findViewById(R.id.QuotesEditText);
        Intent intent = getIntent();
        String Quotes = intent.getStringExtra("Quotes");





        mTextview.setText("Here are all the available Quotes: " + Quotes);


        try {
//            CacheRequest response = null;
//            String jsonData = response.body().toString();
//            Log.v(TAG, jsonData);
            getQuotes(Quotes);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void getQuotes(final String Quotes) throws IOException {
       final QuoteService quoteService = new QuoteService();
        quoteService.findQuotes(Quotes, new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {



            }





            @Override
            public void onResponse(Call call, Response response) throws IOException {
       mQuotes = quoteService.processResults(response);

                QuotesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] restaurantNames = new String[mQuotes.size()];
                        for(int i = 0; i<restaurantNames.length;i++){
                            restaurantNames[i]=mQuotes.get(i).getmQuote();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(QuotesActivity.this, android.R.layout.simple_list_item_1, mQuotes);
                        mListview.setAdapter(adapter);
                        for (Quotes quote : mQuotes) {
                            Log.d(TAG, "Quote: " + quote.getmQuote());
                            Log.d(TAG, "The author is: " + quote.getmAuthor());


                        }
                    }
                });
            }
        });
    }
}
