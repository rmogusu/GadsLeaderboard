package com.example.leaderboad.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboad.R;
import com.example.leaderboad.SkilliqAdapter;

public class SkilliqFragment  extends Fragment {
    public SkilliqFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_blank,container,false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        SkilliqAdapter adapter = new SkilliqAdapter(new String[]{"Perry Zimo","Paul Chenge","Perry Oluwatobi","Perry Sam","Perry Oluwatobi","Perry Oluwatobi","Perry Oluwatobi","Perry Oluwatobi","Perry Oluwatobi","Perry Oluwatobi","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge","Eric Yenge"});
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }
}
