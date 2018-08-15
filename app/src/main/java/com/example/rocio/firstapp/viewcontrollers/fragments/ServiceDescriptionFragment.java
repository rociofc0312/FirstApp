package com.example.rocio.firstapp.viewcontrollers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rocio.firstapp.R;


public class ServiceDescriptionFragment extends Fragment {

    Button btnMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_service_description, container, false);
        btnMap = (Button) view.findViewById(R.id.description_service_button);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                GoogleMapFragment mGoogleMapFragment = new GoogleMapFragment();
                fragmentTransaction.replace(R.id.main_content_frame, mGoogleMapFragment, getString(R.string.tag_fragment_google_map));
                fragmentTransaction.addToBackStack(getString(R.string.tag_fragment_google_map));
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
