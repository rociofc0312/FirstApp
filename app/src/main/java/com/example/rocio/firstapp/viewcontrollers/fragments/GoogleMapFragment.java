package com.example.rocio.firstapp.viewcontrollers.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rocio.firstapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapFragment extends Fragment implements OnMapReadyCallback{

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    Button btnList;


    private static final LatLng SERVER1 = new LatLng(-12.135176, -77.021393);
    private static final LatLng SERVER2 = new LatLng(-12.136345, -77.021731);
    private static final LatLng SERVER3 = new LatLng(-12.133732, -77.022063);
    private static final LatLng SERVER4 = new LatLng(-12.134088, -77.025033);
    private static final LatLng SERVER5 = new LatLng(-12.132332, -77.027485);
    private static final LatLng SERVER6 = new LatLng(-12.130433, -77.023300);

    private Marker mServer1;
    private Marker mServer2;
    private Marker mServer3;
    private Marker mServer4;
    private Marker mServer5;
    private Marker mServer6;

    public GoogleMapFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_google_map, container, false);
        btnList = (Button) mView.findViewById(R.id.btn_serviciales);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment mHomeFragment = new HomeFragment();
                fragmentTransaction.replace(R.id.main_content_frame, mHomeFragment, getString(R.string.tag_fragment_home));
                fragmentTransaction.addToBackStack(getString(R.string.tag_fragment_home));
                fragmentTransaction.commit();
            }
        });
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) mView.findViewById(R.id.map_view);
        if (mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        CameraPosition liberty = CameraPosition.builder().target(new LatLng(-12.1351432, -77.02214909999999)).zoom(16).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty));

        mServer1 = mGoogleMap.addMarker(new MarkerOptions().position(SERVER1).title("Servicial 1"));
        mServer2 = mGoogleMap.addMarker(new MarkerOptions().position(SERVER2).title("Servicial 2"));
        mServer3 = mGoogleMap.addMarker(new MarkerOptions().position(SERVER3).title("Servicial 3"));
        mServer4 = mGoogleMap.addMarker(new MarkerOptions().position(SERVER4).title("Servicial 4"));
        mServer5 = mGoogleMap.addMarker(new MarkerOptions().position(SERVER5).title("Servicial 5"));
        mServer6 = mGoogleMap.addMarker(new MarkerOptions().position(SERVER6).title("Servicial 6"));

        mServer1.setTag(0);
    }
}
