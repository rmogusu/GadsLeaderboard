package com.example.leaderboad.services;

import com.example.leaderboad.Constants;
import com.example.leaderboad.LearnersResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LearnersService {
    public static void findTopLearners(Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<LearnersResponse> processResults(Response response) {
        ArrayList<LearnersResponse> learners = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            JSONObject learnersJSON = new JSONObject(jsonData);
            JSONArray LearnersJSON = learnersJSON.getJSONArray("api/hours");
            if (response.isSuccessful()) {
                for (int i = 0; i < LearnersJSON.length(); i++) {
                    JSONObject LearnerJSON = LearnersJSON.getJSONObject(i);
                    String name = LearnerJSON.getString("name");
                    String country = LearnerJSON.optString("country");
                    String badgeUrl = LearnerJSON.getString("badgeUrl");
                    int hours= LearnerJSON.getInt("hours");



                    LearnersResponse learnersResponse = new LearnersResponse(name,hours,country,badgeUrl);
                    learners.add(learnersResponse);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return learners;
    }
}
