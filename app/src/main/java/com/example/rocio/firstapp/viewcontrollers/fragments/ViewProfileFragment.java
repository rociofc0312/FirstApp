package com.example.rocio.firstapp.viewcontrollers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rocio.firstapp.R;
import com.example.rocio.firstapp.model.Server;


public class ViewProfileFragment extends Fragment {

    private Server mServer;
    private static final String TAG = "ViewProfileFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            mServer = bundle.getParcelable(getString(R.string.intent_user));
            Log.d(TAG, "onCreate: get incoming bundle: " + mServer.getName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_profile, container, false);
    }

}
