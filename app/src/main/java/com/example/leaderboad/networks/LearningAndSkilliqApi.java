package com.example.leaderboad.networks;


import com.example.leaderboad.models.LearnersResponse;
import com.example.leaderboad.models.SkilliqResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearningAndSkilliqApi {
    @GET("/api/hours")
    Call<List<LearnersResponse>> getLearners();
    @GET("/api/skilliq")
    Call<List<SkilliqResponse>> getSkillIqs();
}
