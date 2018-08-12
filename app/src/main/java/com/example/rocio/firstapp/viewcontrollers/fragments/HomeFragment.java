package com.example.rocio.firstapp.viewcontrollers.fragments;
import android.os.Bundle;
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
import com.example.rocio.firstapp.util.Servers;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";
    //constant
    private static final int NUM_COLUMNS = 2;

    //widgets
    private RecyclerView mRecyclerView;

    //vars
    private ArrayList<Server> mListServers = new ArrayList<>();
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private MainRecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Log.d(TAG, "onCreateView: started.");
        mRecyclerView = view.findViewById(R.id.recycler_view);

        findServers();

        return view;
    }

    private void findServers(){
        Servers servers = new Servers();
        if(mListServers != null){
            mListServers.clear();
        }
        for (Server server : servers.SERVERS){
            mListServers.add(server);
        }
        if(mRecyclerViewAdapter == null){
            initRecyclerView();
        }
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerView.");
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerViewAdapter = new MainRecyclerViewAdapter(getActivity(), mListServers);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }
}
