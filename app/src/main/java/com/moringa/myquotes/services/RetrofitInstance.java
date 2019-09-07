//package com.moringa.myquotes.services;
//
//import com.moringa.myquotes.Constants;
//
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RetrofitInstance {
//
//        private static Retrofit retrofit = null;
//        private static final String BASE_URL = Constants.favqs_BASE_URL;
//
//        public static Retrofit getClient() {
//            if (retrofit==null) {
//                retrofit = new Retrofit.Builder()
//                        .baseUrl(BASE_URL)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//            }
//            return retrofit;
//        }
//
//}
