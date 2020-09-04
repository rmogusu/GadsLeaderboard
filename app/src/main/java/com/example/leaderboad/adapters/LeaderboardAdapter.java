package com.example.leaderboad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.LearnersResponse;
import com.example.leaderboad.R;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>{
  private  String[] mDataset;



  public static class LeaderboardViewHolder extends  RecyclerView.ViewHolder{

      public CardView mCardView;
      public TextView mTextView;


      public LeaderboardViewHolder(View v){
          super(v);
          mCardView = (CardView) v.findViewById(R.id.card_view);
          mTextView = (TextView) v.findViewById(R.id.tv_text);


      }
  }
  public LeaderboardAdapter(String[] leaderboardDataSet){
      mDataset = leaderboardDataSet;
  }
  @Override
    public LeaderboardAdapter.LeaderboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
      LeaderboardViewHolder vh = new LeaderboardViewHolder(v);
      return vh;
  }
  @Override
    public void onBindViewHolder(LeaderboardViewHolder holder, int position){
      holder.mTextView.setText(mDataset[position]);

  }

  @Override
    public int getItemCount(){
      return mDataset.length;

  }
}
