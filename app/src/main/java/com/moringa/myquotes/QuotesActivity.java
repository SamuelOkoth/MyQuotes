package com.moringa.myquotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.moringa.myquotes.models.Quote;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class QuotesActivity extends AppCompatActivity  {

    private QuotesAdapter adapter;
    private QuotesRepository quotesRepository;
    private List<Quote> mQuotes;

    @BindView(R.id.textView2)  RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quotesRepository = QuotesRepository.getInstance();
        ButterKnife.bind(this);


    }


    private void getQuotes(final List<Quote>quotes) {
        quotesRepository.getQuotes(new RetrofitCallBack() {
            @Override
            public void onSuccess(List<Quote> quotes) {
                mQuotes = quotes;
                adapter = new QuotesAdapter(mQuotes);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(QuotesActivity.this));
                mRecyclerView.setAdapter(adapter);
                mRecyclerView.setHasFixedSize(true);
            }
            @Override
            public void onError() {
                showError();
            }
        });
    }

    public void showError(){
        Toast.makeText(QuotesActivity.this, "Network Error", Toast.LENGTH_SHORT).show();
    }


}

//
// @BindView(R.id.QuotesTextView) TextView mTextview;
// @BindView(R.id.listView) ListView mListview;
//// @BindView(R.id.recyclerView)
////    RecyclerView mRecyclerView;
//    private QuotesListAdapter mAdapter;
//
//
//        public ArrayList<Quotes> mQuotes = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quotes);
//        ButterKnife.bind(this);
//
//        TextView mQuotesEditText = (TextView) findViewById(R.id.QuotesEditText);
//        Intent intent = getIntent();
//        String Quotes = intent.getStringExtra("QuotesResponse");
//
//
//
//
//
//        mTextview.setText("Here are all the available QuotesResponse: " + Quotes);
//
//
//        public void getmQuote(){
//            Constants service = RetrofitInstance.getClient().create(Constants.class);
//            Call<Quotes> call = service.getQuotes(Constants.favqs_KEY);
//            Log.v("MY URL", String.valueOf(call.request().url()));
//
//            call.enqueue(new Callback<Quotes>() {
//                @Override
//                public void onResponse(Call<Quotes> call, Response<Quotes> response) {
//                    List<Quotes> quotes = response.body().getQuotes();
//                    getQuotes(quotes);
//
//
////        try {
//////            CacheRequest response = null;
//////            String jsonData = response.body().toString();
//////            Log.v(TAG, jsonData);
////            getQuotes(QuotesResponse);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////    }
////    private void getQuotes(final String QuotesResponse) throws IOException {
////       final QuoteService quoteService = new QuoteService();
////        quoteService.findQuotes(QuotesResponse, new Callback() {
////
////
////
////
////
////
////
////
////            @Override
////            public void onResponse(Call call, Response response) throws IOException {
////       mQuotes = quoteService.processResults(response);
////
////                QuotesActivity.this.runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        String[] restaurantNames = new String[mQuotes.size()];
////                        for(int i = 0; i<restaurantNames.length;i++){
////                            restaurantNames[i]=mQuotes.get(i).getmQuote();
////                        }
////                        ArrayAdapter adapter = new ArrayAdapter(QuotesActivity.this, android.R.layout.simple_list_item_1, mQuotes);
////                        mListview.setAdapter(adapter);
////                        for (QuotesResponse quote : mQuotes) {
////                            Log.d(TAG, "Quote: " + quote.getmQuote());
////                            Log.d(TAG, "The author is: " + quote.getmAuthor());
////
////
////                        }
////                    }
////                });
////            }
////        });
////    }
//}
