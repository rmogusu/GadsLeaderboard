package com.example.leaderboad.networks;

import com.example.leaderboad.LearnersResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public class LearnersApi {
    @GET("api/hours")
    Call<List<LearnersResponse>> getTopLearners() {
        return null;
    }
}
