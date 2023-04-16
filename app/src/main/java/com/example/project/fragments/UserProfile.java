package com.example.project.fragments;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.project.activitypages.User_Profile;


public class UserProfile extends Fragment {

    public Activity activity;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = activity;

        Intent intent = new Intent(getActivity(), User_Profile.class);
        startActivity(intent);
    }
}