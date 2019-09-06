package com.moringa.myquotes;

import com.moringa.myquotes.models.QuotesResponse;
import com.moringa.myquotes.services.Quoteservices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.moringa.myquotes.Constants.favqs_KEY;
import static com.moringa.myquotes.Constants.favqs_KEY_QUERY_PARAMETER;

public class QuotesRepository {
    private static QuotesResponse quotesResponse;
    private Quoteservices api;

    private QuotesRepository(Quoteservices api) {
        this.api = api;
    }

    public static QuotesResponse getInstance() {
        if (quotesResponse == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.favqs_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            quotesResponse = new QuotesResponse(retrofit.create(Quoteservices.class));
        }
        return quotesResponse;
    }

    public void getQuotes(final RetrofitCallBack callback) {
        api.getQuotes(favqs_KEY, favqs_KEY_QUERY_PARAMETER).enqueue(new Callback<QuotesResponse>() {
            @Override
            public void onResponse(Call<QuotesResponse> call, Response<QuotesResponse> response) {
                if (response.isSuccessful()) {
                    QuotesResponse quotesResponse = response.body();
                    if (quotesResponse != null && quotesResponse.getQuotes() != null) {
                        callback.onSuccess(quotesResponse.getQuotes());
                    } else {
                        callback.onError();
                    }
                } else {
                    callback.onError();
                }
            }

        });
        }
    }






