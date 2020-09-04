package com.example.leaderboad.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.LearnersResponse;
import com.example.leaderboad.adapters.LeaderboardAdapter;
import com.example.leaderboad.R;

public class LeaderboardFragment extends Fragment {

    public LeaderboardFragment(){}


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_blank,container,false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);

        LeaderboardAdapter adapter = new LeaderboardAdapter(new String[]{"Kojo Yeboah","Sam George","Sam George","Kojo Asante","Eric Yenge","Eric Yenge","Eric Yenge","EEric Yenge","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge"});
                rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }
}
