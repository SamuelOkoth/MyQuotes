package com.moringa.myquotes;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuoteService {



        public static void findQuotes(String Quotes, Callback callback) throws IOException {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://150000-quotes.p.rapidapi.com/keyword/Life")
                    .get()
                    .addHeader("x-rapidapi-host", "150000-quotes.p.rapidapi.com")
                    .addHeader("x-rapidapi-key", "77721d23f1msh474eb6b7ee8bfb6p17f285jsnc5b2bccec497")
                    .build();

            Response response = client.newCall(request).execute();


            Call call = client.newCall(request);
            call.enqueue(callback);

        }
}
