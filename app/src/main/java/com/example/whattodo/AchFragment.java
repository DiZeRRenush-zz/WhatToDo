package com.example.whattodo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AchFragment extends Fragment {

    public AchFragment() {
    }

    public static AchFragment newInstance() {
        return new AchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View achView = inflater.inflate(R.layout.achievement_activity, container, false);
        return achView;
    }
}