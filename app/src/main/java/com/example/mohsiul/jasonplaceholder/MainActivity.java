package com.example.mohsiul.jasonplaceholder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        getElements();
    }

        public void getElements(){

        Retrofit retrofit= new Retrofit.Builder().baseUrl(API_Interface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        //Retrofit retrofit= new Retrofit.Builder().baseUrl(Jokes_API.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        API_Interface api=retrofit.create(API_Interface.class);

        Call<List<API_Java>> call= api.getComments();

        call.enqueue(new Callback<List<API_Java>>() {
            @Override
            public void onResponse(Call<List<API_Java>> call, Response<List<API_Java>> response) {

                List<API_Java>comments;
                comments=response.body();
                String Comments[]=new String[comments.size()];

                //Toast.makeText(getApplicationContext(),"fkajkj",Toast.LENGTH_LONG).show();

                for(int i=0;i<comments.size();i++)
                {
                    Comments[i]=comments.get(i).getTitle();

                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,Comments));

            }

            @Override
            public void onFailure(Call<List<API_Java>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

    }
}
