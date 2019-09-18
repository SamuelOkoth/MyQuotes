package com.moringa.myquotes;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringa.myquotes.models.Quote;
import com.moringa.myquotes.util.ItemTouchHelperViewHolder;

public class FirebaseReadViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;
    View mView;
    Context mContext;
    public TextView mQuoteTextView;
    public TextView mAuthor;



    public FirebaseReadViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindQuote(Quote quote) {

        mAuthor= (TextView) mView.findViewById(R.id.authorTextView);
        mQuoteTextView= (TextView) mView.findViewById(R.id.quoteTextView);
        mAuthor.setText(quote.getAuthor());
        mQuoteTextView.setText(quote.getQuote());

    }
    @Override
    public void onItemSelected() {
        Log.d("Animation", "onItemSelected");
        // we will add animations here
    }

    @Override
    public void onItemClear() {
        Log.d("Animation", "onItemClear");
        // we will add animations here
    }



}