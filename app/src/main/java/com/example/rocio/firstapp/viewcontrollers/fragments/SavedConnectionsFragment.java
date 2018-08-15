package com.example.rocio.firstapp.viewcontrollers.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rocio.firstapp.R;
import com.example.rocio.firstapp.adapters.MainRecyclerViewAdapter;
import com.example.rocio.firstapp.model.Server;
import com.example.rocio.firstapp.util.PreferenceKeys;
import com.example.rocio.firstapp.util.Servers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.Inflater;


public class SavedConnectionsFragment extends Fragment {

    private static final int NUM_GRID_COLUMNS = 2;

    private MainRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    private ArrayList<Server> mServers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_saved_connections, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        getConnections();
        return view;
    }

    public void getConnections(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        Set<String> savedNames = preferences.getStringSet(PreferenceKeys.SAVED_CONNECTIONS, new HashSet<String>());

        Servers servers = new Servers();
        if(mServers != null){
            mServers.clear();
        }
        for (Server server: servers.SERVERS){
            if(savedNames.contains(server.getName())){
                mServers.add(server);
            }
        }
        if (mRecyclerViewAdapter == null) {

            initRecyclerView();
        }
    }

    private void initRecyclerView(){
        mRecyclerViewAdapter = new MainRecyclerViewAdapter(getActivity(), mServers);
        StaggeredGridLayoutManager staggeredGridLayoutManager= new StaggeredGridLayoutManager(NUM_GRID_COLUMNS, LinearLayoutManager.VERTICAL);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
    }


}
