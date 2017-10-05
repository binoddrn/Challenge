package com.learn.binod.technoriochallenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.DocumentsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.learn.binod.technoriochallenge.R;
import com.learn.binod.technoriochallenge.activity.PostDetail;
import com.learn.binod.technoriochallenge.model.PostResponse;

import java.util.List;

/**
 * Created by binod on 10/5/2017.
 */

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostListViewHolder> {
    List<PostResponse>responses;
    Context context;

    public PostListAdapter(List<PostResponse> responses,Context context) {
        this.responses = responses;
        this.context=context;
    }

    @Override
    public PostListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_item,parent,false);
        PostListViewHolder postListViewHolder=new PostListViewHolder(view);
        return postListViewHolder;
    }

    @Override
    public void onBindViewHolder(PostListViewHolder holder, final int position) {
        final PostResponse response=responses.get(position);
        holder.postTitle.setText(response.getTitle());
    //    holder.postBody.setText(response.getBody());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    context.startActivity(new Intent(context, PostDetail.class).putExtra("id",response.getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public  static class PostListViewHolder extends RecyclerView.ViewHolder{
        TextView postTitle,postBody;
        LinearLayout root;
        public PostListViewHolder(View itemView) {
            super(itemView);
            postTitle=(TextView)itemView.findViewById(R.id.post_title);
          //  postBody=(TextView)itemView.findViewById(R.id.post_body);
            root=(LinearLayout)itemView.findViewById(R.id.root);
        }
    }
}
