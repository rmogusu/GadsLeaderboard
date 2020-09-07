package com.example.leaderboad.models;

import com.example.leaderboad.R;

public enum ModelObject {
    learning(R.string.learning, R.layout.recyclerview_learners),
    skill(R.string.skill, R.layout.recyclerview_skill);
    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }
}
