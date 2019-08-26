package com.moringa.myquotes;

import android.content.Context;
import android.widget.ArrayAdapter;

public class QuotesArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mQuotes;

    public QuotesArrayAdapter(Context mContext, int resource, String[] mQuotes){

        super(mContext,resource);
        this.mContext = mContext;
        this.mQuotes = mQuotes;
    }
    @Override
    public Object getItem(int position) {
        String Quotes = mQuotes[position];
        return String.format("%s \nServes great: %s", mQuotes);
    }
    @Override
    public int getCount() {
        return mQuotes.length;
    }
}


