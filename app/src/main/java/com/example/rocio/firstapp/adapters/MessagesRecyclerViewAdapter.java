package com.example.rocio.firstapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.rocio.firstapp.IMenuActivity;
import com.example.rocio.firstapp.R;
import com.example.rocio.firstapp.model.Server;
import com.example.rocio.firstapp.util.Messages;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MessagesRecyclerViewAdapter extends RecyclerView.Adapter<MessagesRecyclerViewAdapter.ViewHolder>{

    private static String TAG = "ConnectionsAdapter";
    private ArrayList<Server> mServers = new ArrayList<>();
    private ArrayList<Server> mFavoriteServers = new ArrayList<>();
    private Context mContext;
    private IMenuActivity mInterface;

    public MessagesRecyclerViewAdapter(Context context, ArrayList<Server> servers){
        mContext = context;
        mServers = servers;
        mFavoriteServers = servers;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_messages_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Server server = mFavoriteServers.get(position);

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);
        Glide.with(mContext).load(server.getProfile_image())
                .apply(requestOptions).into(viewHolder.image);
        viewHolder.name.setText(server.getName());
        viewHolder.message.setText(Messages.MESSAGES[position]);
        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + server.getName());
            }
        });
    };

    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if(charString.isEmpty()){
                    mFavoriteServers = mServers;
                } else{
                    ArrayList<Server> favoriteList = new ArrayList<>();
                    for(Server row: mServers){
                        if(row.getName().toLowerCase().contains(charString.toLowerCase())){
                            favoriteList.add(row);
                        }
                    }
                    mFavoriteServers = favoriteList;
                }
                FilterResults favoriteResults = new FilterResults();
                favoriteResults.values = mFavoriteServers;
                return favoriteResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return mFavoriteServers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView message;
        TextView reply;
        ConstraintLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
            this.name = itemView.findViewById(R.id.name);
            this.message = itemView.findViewById(R.id.message);
            this.reply = itemView.findViewById(R.id.parent); //cambiar
            this.parent = itemView.findViewById(R.id.parent_view);
        }
    }
}
