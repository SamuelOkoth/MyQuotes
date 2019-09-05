package com.moringa.myquotes;

public class Quotes {
    private String mQuote;
    private String mAuthor;
    private String mImageUrl;


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

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public Quotes(String Quote, String Author, String ImageUrl){



        this.mQuote = Quote;
        this.mAuthor = Author;
        this.mImageUrl = ImageUrl;
    }


}
