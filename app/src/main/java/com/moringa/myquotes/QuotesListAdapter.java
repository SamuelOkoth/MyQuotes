package com.moringa.myquotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class QuotesListAdapter extends RecyclerView.Adapter<QuotesListAdapter.QuotesViewHolder> {
    private ArrayList<Quotes> mQuotes = new ArrayList<>();
    private Context mContext;

    public QuotesListAdapter(Context context, ArrayList<Quotes> quotes) {
        mContext = context;
        mQuotes = Quotes;

    }

    @Override
    public QuotesListAdapter.QuotesViewHolder onCreateViewHolder(ViewGroup parent, String viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_list_item, parent, false);
        QuotesViewHolder viewHolder = new QuotesViewHolder(view);
        return viewHolder;
    }



    public class QuotesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.QuotesTextView) TextView mQuotesTextView;
        @BindView(R.id.AuthorTextView) TextView mAuthorTextView;
        @BindView(R.id.Quotes)
        ImageView mQuotesImageView;
         private Context mContext;

        public QuotesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindQuotes(Quotes quote) {
            mQuotesTextView.setText(quote.getmQuote());
            mAuthorTextView.setText(quote.getmAuthor());

        }
    }
}