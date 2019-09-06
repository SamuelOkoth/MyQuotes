package com.moringa.myquotes;

import com.moringa.myquotes.models.Quote;

import java.util.List;

public interface RetrofitCallBack {
   void onSuccess(List<Quote>quote);

   void onError();
}
