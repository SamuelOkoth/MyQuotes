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
    private static QuotesRepository quotesRepository;
    private Quoteservices api;

    private QuotesRepository(Quoteservices api) {
        this.api = api;
    }



    public static QuotesRepository getInstance() {
        if (quotesRepository == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.favqs_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            quotesRepository = new QuotesRepository(retrofit.create(Quoteservices.class));
        }
        return quotesRepository;
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

            @Override
            public void onFailure(Call<QuotesResponse>call,Throwable t){
                callback.onError();
            }

        });
    }
}






