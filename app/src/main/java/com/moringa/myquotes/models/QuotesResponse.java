package com.moringa.myquotes.models;

        import java.io.Serializable;
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;
        import com.moringa.myquotes.services.Quoteservices;

public class QuotesResponse {


    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("last_page")
    @Expose
    private Boolean lastPage;
    @SerializedName("quotes")
    @Expose
    private List<Quote> quotes = null;
    private final static long serialVersionUID = 4157856814347337187L;

    public QuotesResponse(Quoteservices quoteservices) {

    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Boolean getLastPage() {
        return lastPage;
    }

    public void setLastPage(Boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

}