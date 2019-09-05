package com.moringa.myquotes.services;

import com.moringa.myquotes.Constants;
import com.moringa.myquotes.Quotes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuoteService {
    public static void findQuotes(String Quotes, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.favqs_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.favqs_KEY_QUERY_PARAMETER, Quotes);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", Constants.favqs_KEY)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
    public static ArrayList<Quotes> processResults(Response response) {
        ArrayList<Quotes> quotes = new ArrayList<>();
        try {
            String data = response.body().string();
            JSONArray jsonArray= new JSONArray(data);
            for(int i=0; i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Quotes newQuote = new Quote("Quote","Author");
                newQuote.getmAuthor();
                newQuote.getmAuthor();
                quotes.add(newQuote);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quotes;
    }
    private static class Quote extends Quotes {
        public Quote(String Quote, String Author) {
            super("Quote","Author");
        }
    }
}
//    public static void processResults(Response response) throws JSONException, IOException {
//        String jsonData = response.body().string();
//        JSONObject rapidapiJSON = new JSONObject(jsonData);
//        JSONArray authorJSON = rapidapiJSON.getJSONArray("author");
//
//        if (response.isSuccessful()) {
//            for (int i = 0; i < authorJSON.length(); i++) {
//                JSONObject quotesJSON = authorJSON.getJSONObject(i);
//                String mQuote = quotesJSON.getString("Quotes");
//                String mAuthor = quotesJSON.getString("Author");
//                String mImageUrl = quotesJSON.getString("image_url");
//
//
//                Quotes quote = new Quotes(mQuote, mAuthor, mImageUrl);
//            }
//
//        }
//
//    }


