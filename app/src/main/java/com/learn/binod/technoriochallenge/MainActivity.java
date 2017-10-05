package com.learn.binod.technoriochallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.learn.binod.technoriochallenge.adapter.PostListAdapter;
import com.learn.binod.technoriochallenge.model.Post;
import com.learn.binod.technoriochallenge.model.PostResponse;
import com.learn.binod.technoriochallenge.networking.ApiClient;
import com.learn.binod.technoriochallenge.networking.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    PostListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.activity_main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

   /*     ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<PostResponse>call=apiInterface.getPostList();
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
              PostResponse   responsed=response.body();

           //     String ioio=postResponse.getBody();
                 Log.e("Body Description",new Gson().toJson(responsed).toString());
           //     Log.e("Response", response.body());
          //      adapter =new PostListAdapter(postResponse,MainActivity.this);
          //      recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });
        */

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<PostResponse> call=apiInterface.getPostList();
        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
              PostResponse postResponse= response.body();

                Log.e("Response",postResponse.toString());
                adapter=new PostListAdapter(postResponse.getPost(),MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {

            }
        });

    }
}
