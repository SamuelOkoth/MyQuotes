
package com.example.quotes.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

@Parcel
public class Quote {

//    @SerializedName("author")
//    @Expose
    private String author;
//    @SerializedName("id")
//    @Expose
    private Integer id;
//    @SerializedName("quote")
//    @Expose
    private String quote;
//    @SerializedName("permalink")
//    @Expose
    private String permalink;
    private String pushId;
    String index;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Quote() {
    }

    /**
     * 
     * @param id
     * @param author
     * @param permalink
     * @param quote
     */
    public Quote(String author, Integer id, String quote, String permalink) {
        super();
        this.author = author;
        this.id = id;
        this.quote = quote;
        this.permalink = permalink;
        this.index = "not_specified";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }
    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

}
