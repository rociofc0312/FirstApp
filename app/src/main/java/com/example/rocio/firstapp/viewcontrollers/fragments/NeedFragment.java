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


public class NeedFragment extends Fragment {

    Button btnService;



    public NeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_need, container, false);
        btnService = (Button) view.findViewById(R.id.button_service_detail);
        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ServiceDescriptionFragment mServiceDescriptionFragment = new ServiceDescriptionFragment();
                fragmentTransaction.replace(R.id.main_content_frame, mServiceDescriptionFragment, getString(R.string.tag_fragment_services_detail));
                fragmentTransaction.addToBackStack(getString(R.string.tag_fragment_services_detail));
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
