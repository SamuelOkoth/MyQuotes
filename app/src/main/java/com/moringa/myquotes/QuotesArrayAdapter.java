package com.moringa.myquotes;

import android.content.Context;
import android.widget.ArrayAdapter;

public class QuotesArrayAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mQuotes;

    public QuotesArrayAdapter(Context mContext, String quotes, String[] mQuotes){

        super(mContext,mQuotes);
        this.mContext = mContext;
        this.mQuotes = mQuotes;
    }
    @Override
    public Object getQuotes(String quotes) {
        String Quotes = mQuotes[Integer.parseInt(quotes)];
        return String.format("%s \nServes great: %s", mQuotes);
    }
    public String[] getQuotes() {
        return mQuotes;
    }
}


