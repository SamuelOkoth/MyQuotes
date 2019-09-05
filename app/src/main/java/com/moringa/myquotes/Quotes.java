package com.moringa.myquotes;

public class Quotes {
    private String mQuote;
    private String mAuthor;


    public String getmQuote() {
        return mQuote;
    }

    public void setmQuote(String mQuote) {
        this.mQuote = mQuote;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public void setmAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }




    public Quotes(String Quote, String Author){



        this.mQuote = Quote;
        this.mAuthor = Author;
    }


}
