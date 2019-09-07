package com.moringa.myquotes.models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

public class Quote{


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

//{
//
//    @SerializedName("tags")
//    @Expose
//    private List<String> tags = null;
//    @SerializedName("favorite")
//    @Expose
//    private Boolean favorite;
//    @SerializedName("author_permalink")
//    @Expose
//    private String authorPermalink;
//    @SerializedName("body")
//    @Expose
//    private String body;
//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("favorites_count")
//    @Expose
//    private Integer favoritesCount;
//    @SerializedName("upvotes_count")
//    @Expose
//    private Integer upvotesCount;
//    @SerializedName("downvotes_count")
//    @Expose
//    private Integer downvotesCount;
//    @SerializedName("dialogue")
//    @Expose
//    private Boolean dialogue;
//    @SerializedName("author")
//    @Expose
//    private String author;
//    @SerializedName("url")
//    @Expose
//    private String url;
//    private final static long serialVersionUID = -7268731812471705980L;
//
//    public List<String> getTags() {
//        return tags;
//    }
//
//    public void setTags(List<String> tags) {
//        this.tags = tags;
//    }
//
//    public Boolean getFavorite() {
//        return favorite;
//    }
//
//    public void setFavorite(Boolean favorite) {
//        this.favorite = favorite;
//    }
//
//    public String getAuthorPermalink() {
//        return authorPermalink;
//    }
//
//    public void setAuthorPermalink(String authorPermalink) {
//        this.authorPermalink = authorPermalink;
//    }
//
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getFavoritesCount() {
//        return favoritesCount;
//    }
//
//    public void setFavoritesCount(Integer favoritesCount) {
//        this.favoritesCount = favoritesCount;
//    }
//
//    public Integer getUpvotesCount() {
//        return upvotesCount;
//    }
//
//    public void setUpvotesCount(Integer upvotesCount) {
//        this.upvotesCount = upvotesCount;
//    }
//
//    public Integer getDownvotesCount() {
//        return downvotesCount;
//    }
//
//    public void setDownvotesCount(Integer downvotesCount) {
//        this.downvotesCount = downvotesCount;
//    }
//
//    public Boolean getDialogue() {
//        return dialogue;
//    }
//
//    public void setDialogue(Boolean dialogue) {
//        this.dialogue = dialogue;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//}
