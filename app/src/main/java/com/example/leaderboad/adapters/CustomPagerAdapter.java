package com.example.leaderboad.adapters;
import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;


import com.example.leaderboad.R;
import com.example.leaderboad.models.LearnersResponse;
import com.example.leaderboad.models.ModelObject;
import com.example.leaderboad.models.SkilliqResponse;
import com.example.leaderboad.networks.LearningAndSkilliqApi;
import com.example.leaderboad.services.RetrofitGet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomPagerAdapter extends PagerAdapter{
    Context mContext;
    LayoutInflater inflater;
    ViewGroup layout;
    RecyclerView recyclerView_learners;
    RecyclerView recyclerView_skill;
    public CustomPagerAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ModelObject modelObject=ModelObject.values()[position];
        inflater = LayoutInflater.from(collection.getRootView().getContext());
        layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        collection.addView(layout);
        recyclerView_learners=collection.findViewById(R.id.recyclerview_learners);
        recyclerView_skill=collection.findViewById(R.id.recyclerview_skill);
        if(recyclerView_learners!=null){
           LearningAndSkilliqApi getter = RetrofitGet.getRetrofit().create(LearningAndSkilliqApi.class);
            Call<List<LearnersResponse>> call = getter.getLearners();
            call.enqueue(new Callback<List<LearnersResponse>>() {
                @Override
                public void onResponse(Call<List<LearnersResponse>> call, Response<List<LearnersResponse>> response) {
                    generateLearnersDataList(response.body());
                }

                @Override
                public void onFailure(Call<List<LearnersResponse>> call, Throwable t) {
                }
            });
            if(recyclerView_skill!=null){
                LearningAndSkilliqApi getter_ = RetrofitGet.getRetrofit().create(LearningAndSkilliqApi.class);
                Call<List<SkilliqResponse>> call_ = getter_.getSkillIqs();
                call_.enqueue(new Callback<List<SkilliqResponse>>() {
                    @Override
                    public void onResponse(Call<List<SkilliqResponse>> call_, Response<List<SkilliqResponse>> response) {
                        generateSKillsDataList(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<SkilliqResponse>> call_, Throwable t) {
                    }
                });
            }
        }
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, @NonNull Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ModelObject customPagerEnum = ModelObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }


    private void generateLearnersDataList(List<LearnersResponse> learners) {
        RecyclerViewAdapterLearners adapter = new RecyclerViewAdapterLearners(mContext,learners);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView_learners.setLayoutManager(layoutManager);
        recyclerView_learners.setAdapter(adapter);
    }
    private void generateSKillsDataList(List<SkilliqResponse> skillIqs) {
        RecyclerViewAdapterSkill adapter = new RecyclerViewAdapterSkill(mContext,skillIqs);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext);
        recyclerView_skill.setLayoutManager(layoutManager);
        recyclerView_skill.setAdapter(adapter);
    }
}
