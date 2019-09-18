package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.quotes.models.Quote;
import java.io.IOException;
import java.util.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ReadActivity extends AppCompatActivity {

    public static final String TAG = ReadActivity.class.getSimpleName();
    private SharedPreferences mSharedPreferences;
    private String mRecentName;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private ReadListAdapter mAdapter;

   public ArrayList<Quote> mQuotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        ButterKnife.bind(this);
        getQuotes("author");
    }

    private void getQuotes(String author) {
        final QuoteService quoteService = new QuoteService();
        quoteService.findQuotes(author, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override

            public void onResponse(Call call, Response response) {

                mQuotes = quoteService.processResults(response);
                ReadActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new ReadListAdapter(ReadActivity.this, mQuotes);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ReadActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
                    }

                });
            }


}