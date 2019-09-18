package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.quotes.models.Quote;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadDetailActivity extends AppCompatActivity {


    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    private ReadPagerAdapter adapterViewPager;
    ArrayList<Quote> mQuotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_detail);
        ButterKnife.bind(this);

        mQuotes = Parcels.unwrap(getIntent().getParcelableExtra("quotes"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ReadPagerAdapter(getSupportFragmentManager(), mQuotes);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
