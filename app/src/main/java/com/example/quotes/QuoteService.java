package com.example.quotes;

import com.example.quotes.models.Quote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class QuoteService {
    public static void findQuotes(String id, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.QUOTE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.QUOTE_AUTHOR_QUERY_PARAMETER, "author");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }
    public static ArrayList<Quote> processResults(Response response) {
        ArrayList<Quote> quotes = new ArrayList<>();

        try {
            String data = response.body().string();
            JSONArray jsonArray= new JSONArray(data);
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Quote newQuote = new Quote();
                newQuote.setAuthor(jsonObject.getString("author"));
                newQuote.setQuote(jsonObject.getString("quote"));
                newQuote.setPermalink(jsonObject.getString("permalink"));
                newQuote.setId(jsonObject.getInt("id"));
                quotes.add(newQuote);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return quotes;
    }
}
