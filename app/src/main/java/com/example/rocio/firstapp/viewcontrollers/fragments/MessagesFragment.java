package com.example.rocio.firstapp.viewcontrollers.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rocio.firstapp.R;
import com.example.rocio.firstapp.adapters.MessagesRecyclerViewAdapter;
import com.example.rocio.firstapp.model.Server;
import com.example.rocio.firstapp.util.PreferenceKeys;
import com.example.rocio.firstapp.util.Servers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class MessagesFragment extends Fragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MessagesRecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    private ArrayList<Server> mServers = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
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

    public void initRecyclerView(){
        mRecyclerViewAdapter = new MessagesRecyclerViewAdapter(getActivity(), mServers);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
