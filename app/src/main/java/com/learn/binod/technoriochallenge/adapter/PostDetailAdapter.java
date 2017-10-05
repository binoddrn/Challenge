package com.learn.binod.technoriochallenge.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.binod.technoriochallenge.R;

import java.util.List;

/**
 * Created by binod on 10/5/2017.
 */

public class PostDetailAdapter extends RecyclerView.Adapter<PostDetailAdapter.PostDetailViewHolder> {
   private List<PostResponse>responses;



    public PostDetailAdapter(List<PostResponse> responses) {
        this.responses = responses;

    }

    @Override
    public PostDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_detail_item,parent,false);
        PostDetailViewHolder viewHolde=new PostDetailViewHolder(view);
        return viewHolde;
    }

    @Override
    public void onBindViewHolder(PostDetailViewHolder holder, int position) {
        PostResponse response=responses.get(position);
        holder.PostDetail.setText(response.getBody());
    }

    @Override
    public int getItemCount() {
        return responses.size();
    }

    public static class  PostDetailViewHolder extends RecyclerView.ViewHolder{
        TextView PostDetail;
        public PostDetailViewHolder(View itemView) {
            super(itemView);
            PostDetail=(TextView)itemView.findViewById(R.id.txtpostDetail);
        }
    }

}
