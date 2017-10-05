package com.learn.binod.technoriochallenge.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.learn.binod.technoriochallenge.R;
import com.learn.binod.technoriochallenge.adapter.PostDetailAdapter;
import com.learn.binod.technoriochallenge.adapter.PostListAdapter;
import com.learn.binod.technoriochallenge.model.PostResponse;
import com.learn.binod.technoriochallenge.networking.ApiClient;
import com.learn.binod.technoriochallenge.networking.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetail extends AppCompatActivity {
    private RecyclerView mrecyclerview;
    private List<PostResponse>responses;
    PostDetailAdapter madapter;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        id=getIntent().getStringExtra("id");
        mrecyclerview=(RecyclerView)findViewById(R.id.activity_post_detail_recyclerview);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<List<PostResponse>>call=apiInterface.getPostDetail(id);
        call.enqueue(new Callback<List<PostResponse>>() {
            @Override
            public void onResponse(Call<List<PostResponse>> call, Response<List<PostResponse>> response) {
               List <PostResponse> responses=response.body();
                Log.d("Response",responses.toString());
                madapter=new PostDetailAdapter(responses);
                mrecyclerview.setAdapter(madapter);
            }

            @Override
            public void onFailure(Call<List<PostResponse>> call, Throwable t) {

            }
        });




    }
}
