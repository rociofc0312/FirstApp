package com.example.rocio.firstapp.viewcontrollers.activities;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.rocio.firstapp.IMenuActivity;
import com.example.rocio.firstapp.R;
import com.example.rocio.firstapp.model.Server;
import com.example.rocio.firstapp.util.PreferenceKeys;
import com.example.rocio.firstapp.viewcontrollers.fragments.GoogleMapFragment;
import com.example.rocio.firstapp.viewcontrollers.fragments.HomeFragment;
import com.example.rocio.firstapp.viewcontrollers.fragments.MessagesFragment;
import com.example.rocio.firstapp.viewcontrollers.fragments.NeedFragment;
import com.example.rocio.firstapp.viewcontrollers.fragments.SavedConnectionsFragment;
import com.example.rocio.firstapp.viewcontrollers.fragments.ViewProfileFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MenuActivity extends AppCompatActivity implements IMenuActivity, BottomNavigationViewEx.OnNavigationItemSelectedListener{

    private static final  String TAG = "MainActivity";
    private BottomNavigationViewEx mBottomNavigationViewEx;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.bottom_nav_home:{
                Log.d(TAG, "onNavigationItemSelected: HomeFragment");
                NeedFragment homeFragment = new NeedFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content_frame, homeFragment, getString(R.string.tag_fragment_need));
                transaction.addToBackStack(getString(R.string.tag_fragment_need));
                transaction.commit();
                menuItem.setChecked(true);
                break;
            }
            case R.id.bottom_nav_history:{
                Log.d(TAG, "onNavigationItemSelected: HistoryFragment");
                MessagesFragment messagesFragment = new MessagesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content_frame, messagesFragment, getString(R.string.tag_fragment_messages));
                transaction.addToBackStack(getString(R.string.tag_fragment_messages));
                transaction.commit();
                menuItem.setChecked(true);
                break;
            }
            case R.id.bottom_nav_favorite:{
                Log.d(TAG, "onNavigationItemSelected: FavoriteFragment");
                SavedConnectionsFragment savedConnectionsFragment = new SavedConnectionsFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content_frame, savedConnectionsFragment, getString(R.string.tag_fragment_saved_connections));
                transaction.addToBackStack(getString(R.string.tag_fragment_saved_connections));
                transaction.commit();
                menuItem.setChecked(true);
                break;
            }
            case R.id.bottom_nav_profile:{
                Log.d(TAG, "onNavigationItemSelected: GoogleMapFragment");
                GoogleMapFragment googleMapFragment = new GoogleMapFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_content_frame, googleMapFragment, getString(R.string.tag_fragment_google_map));
                transaction.addToBackStack(getString(R.string.tag_fragment_google_map));
                transaction.commit();
                menuItem.setChecked(true);
                break;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mBottomNavigationViewEx = findViewById(R.id.bottom_nav_view);

        mBottomNavigationViewEx.setOnNavigationItemSelectedListener(this);
        //isFirstLogin();
        init();
        //initBottomNavigationView();
    }

    private void initBottomNavigationView(){
        Log.d(TAG, "initBottomNavigationView: initializing bottom navigation");
        mBottomNavigationViewEx.enableAnimation(false);
    }

    private void isFirstLogin(){
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstLogin = preferences.getBoolean(PreferenceKeys.FIRST_TIME_LOGIN, true);

        if(isFirstLogin){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(getString(R.string.first_time_message));
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean(PreferenceKeys.FIRST_TIME_LOGIN, false);
                    editor.apply();
                    dialogInterface.dismiss();
                }
            });
            alertDialogBuilder.setIcon(R.drawable.ic_launcher_foreground);
            alertDialogBuilder.setTitle(" ");
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    private void init(){

        NeedFragment homeFragment = new NeedFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame, homeFragment, getString(R.string.tag_fragment_need));
        transaction.addToBackStack(getString(R.string.tag_fragment_need));
        transaction.commit();
    }

    @Override
    public void inflateViewProfileFragment(Server server) {
        ViewProfileFragment viewProfileFragment = new ViewProfileFragment();

        Bundle args = new Bundle();
        args.putParcelable(getString(R.string.intent_user), server);
        viewProfileFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame, viewProfileFragment, getString(R.string.tag_fragment_view_profile));
        transaction.addToBackStack(getString(R.string.tag_fragment_view_profile));
        transaction.commit();
    }

}
