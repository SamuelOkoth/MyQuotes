package com.moringa.myquotes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

class QuotesActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private String mRecentAuthor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentAuthor = mSharedPreferences.getString(Constants.PREFERENCES_AUTHOR_KEY, null);
        Log.d("Shared Pref Location", mRecentAuthor);
    }
    }
