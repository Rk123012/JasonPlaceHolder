package com.example.mohsiul.jasonplaceholder;

import com.google.gson.annotations.SerializedName;

public class API_Java {

    @SerializedName("UserId")
    public int UserId;
    @SerializedName("id")
    public int id;
    @SerializedName("title")
    public String title;

    public API_Java(int userId, int id, String title) {
        UserId = userId;
        id = id;
        title = title;
    }

    public int getUserId() {
        return UserId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
