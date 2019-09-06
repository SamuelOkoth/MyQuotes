package com.moringa.myquotes;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.moringa.myquotes.models.Quote;


import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder> {
    private List<Quote> quotes;

    public QuotesAdapter(List<Quote> quotes) {
        this.quotes = quotes;

    }
    @Override
    public QuotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quotes_list_item, parent, false);
        return new QuotesViewHolder(view);
    }
    @Override
    public void onBindViewHolder(QuotesViewHolder holder, int position) {
        holder.bind(quotes.get(position));
    }
    @Override
    public int getItemCount() {
        return quotes.size();
    }
    class QuotesViewHolder extends RecyclerView.ViewHolder {

        TextView quote;



        public QuotesViewHolder(View itemView) {
            super(itemView);
            quote = itemView.findViewById(R.id.textView2);

        }
        public void bind(Quote quotes) {
            quote.setText(quotes.getBody());

        }

                }
            }



