package com.moringa.myquotes.services;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Quoteservices {

    @GET("app/quote")
    Call<Result> getQuote(@Query("Quote") String Quote, @Query("favqs_KEY") String favqs_KEY);
}
