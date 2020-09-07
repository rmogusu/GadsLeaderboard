package com.example.leaderboad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.R;
import com.example.leaderboad.models.SkilliqResponse;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterSkill extends RecyclerView.Adapter<RecyclerViewAdapterSkill.CustomViewHolder>{
    private List<SkilliqResponse> dataList;
    private Context context;

    public RecyclerViewAdapterSkill(Context context,List<SkilliqResponse> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView name;
        TextView score_country;
        ImageView badge;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            name = mView.findViewById(R.id.name);
            score_country=mView.findViewById(R.id.score_country);
            badge = mView.findViewById(R.id.badge);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.skilliq_card_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.name.setText(dataList.get(position).getName());
        String score_country=dataList.get(position).getScore()+" skill IQ score, "+dataList.get(position).getCountry()+".";
        holder.score_country.setText(score_country);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getBadgeUrl())
                .placeholder((R.drawable.skill))
                .error(R.drawable.ic_launcher_background)
                .into(holder.badge);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
