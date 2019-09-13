package com.example.quotes;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class QuotesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<String> mAuthors = new ArrayList<String>();
    private ArrayList<String> mQuotes = new ArrayList<String>();

    public QuotesArrayAdapter(Context mContext, int resource, ArrayList<String> mAuthors, ArrayList<String> mQuotes){
        super(mContext, resource);
        this.mContext = mContext;
        this.mAuthors = mAuthors;
        this.mQuotes = mQuotes;
    }
    @Override
        public Object getItem(int position){
        String author = mAuthors.get(position);
        String quote = mQuotes.get(position);
           return String.format( "\n %S WROTE %S\n ", author, quote);
    }
    @Override
    public int getCount(){
     return mAuthors.size();
    }
}
