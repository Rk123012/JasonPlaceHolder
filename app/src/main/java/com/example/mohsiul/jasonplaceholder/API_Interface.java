package com.example.mohsiul.jasonplaceholder;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API_Interface {

    public  String BASE_URL="https://jsonplaceholder.typicode.com/";

    @GET("albums")
    Call<List<API_Java>> getComments();

}
