package com.example.leaderboad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class SkilliqAdapter extends RecyclerView.Adapter<SkilliqAdapter.SkilliqViewHolder>{
    private  String[] mDataset;

    public static class SkilliqViewHolder extends  RecyclerView.ViewHolder{
        public CardView mCardView;
        public TextView mTextView;
        public SkilliqViewHolder(View v){
            super(v);
            mCardView = (CardView) v.findViewById(R.id.card_view2);
            mTextView= (TextView) v.findViewById(R.id.tv_text2);

        }
    }
    public SkilliqAdapter(String[] skilliqDataSet){
        mDataset = skilliqDataSet;
    }
    @Override
    public SkilliqAdapter.SkilliqViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item2,parent,false);
        SkilliqAdapter.SkilliqViewHolder vh = new SkilliqAdapter.SkilliqViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(SkilliqAdapter.SkilliqViewHolder holder, int position){
        holder.mTextView.setText(mDataset[position]);
    }
    @Override
    public int getItemCount(){
        return mDataset.length;
    }
}
