package com.example.rocio.firstapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rocio.firstapp.IMenuActivity;
import com.example.rocio.firstapp.R;
import com.example.rocio.firstapp.model.Server;

import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "MainRecyclerViewAd";

    private ArrayList<Server> mServers = new ArrayList<>();
    private Context mContext;
    private IMenuActivity mInterface;

    public MainRecyclerViewAdapter(Context context, ArrayList<Server> servers){
        mContext = context;
        mServers = servers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_main_feed, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
        Glide.with(mContext).load(mServers.get(position).getProfile_image())
                .apply(requestOptions)
                .into(viewHolder.profile_image);
        viewHolder.name.setText(mServers.get(position).getName());
        viewHolder.qualification.setText(mServers.get(position).getQualification());
        viewHolder.status.setText(mServers.get(position).getStatus());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on" + mServers.get(position).getName());
                mInterface.inflateViewProfileFragment(mServers.get(position));
            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mInterface = (IMenuActivity) mContext;

    }

    @Override
    public int getItemCount() {
        return mServers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView profile_image;
        TextView name;
        TextView qualification;
        TextView status;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            qualification = itemView.findViewById(R.id.qualification);
            status = itemView.findViewById(R.id.status);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
