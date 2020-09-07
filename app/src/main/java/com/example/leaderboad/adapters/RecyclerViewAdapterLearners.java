package com.example.leaderboad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.R;
import com.example.leaderboad.models.LearnersResponse;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterLearners extends RecyclerView.Adapter<RecyclerViewAdapterLearners.CustomViewHolder>{
    private List<LearnersResponse> dataList;
    private Context context;

    public RecyclerViewAdapterLearners(Context context, List<LearnersResponse> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView name;
        TextView hours_country;
        ImageView badge;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            name = mView.findViewById(R.id.name);
            hours_country=mView.findViewById(R.id.hours_country);
            badge = mView.findViewById(R.id.badge);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.learning_card_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.name.setText(dataList.get(position).getName());
        String hours_country=dataList.get(position).getHours()+" learning hours, "+dataList.get(position).getCountry()+".";
        holder.hours_country.setText(hours_country);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(dataList.get(position).getBadgeUrl())
                .placeholder((R.drawable.toplearner))
                .error(R.drawable.toplearner)
                .into(holder.badge);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
