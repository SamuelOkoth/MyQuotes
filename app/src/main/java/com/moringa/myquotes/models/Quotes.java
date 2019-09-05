
package com.moringa.myquotes.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quotes implements Serializable
{

    @SerializedName("qotd_date")
    @Expose
    private String qotdDate;
    @SerializedName("quote")
    @Expose
    private Quote quote;
    private final static long serialVersionUID = 4276890244037772606L;

    public String getQotdDate() {
        return qotdDate;
    }

    public void setQotdDate(String qotdDate) {
        this.qotdDate = qotdDate;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

}
