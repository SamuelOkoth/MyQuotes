package com.example.quotes;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.quotes.ReadDetailFragment;
import com.example.quotes.models.Quote;

import java.util.ArrayList;

public class ReadPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Quote> mQuotes;

    public ReadPagerAdapter(FragmentManager fm, ArrayList<Quote> quotes){
        super(fm);
        mQuotes = quotes;
    }

    @Override
    public Fragment getItem(int position){
        return ReadDetailFragment.newInstance(mQuotes.get(position));
    }

    @Override
    public int getCount(){
        return mQuotes.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mQuotes.get(position).getAuthor();
    }
}