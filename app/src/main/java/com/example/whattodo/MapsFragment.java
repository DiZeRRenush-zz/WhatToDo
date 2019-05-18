package com.example.whattodo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.location.Location;
import android.support.annotation.NonNull;

public class MapsFragment extends Fragment implements
        OnClickListener,
        NavigationView.OnNavigationItemSelectedListener,
        OnMapReadyCallback,
        GoogleMap.OnMyLocationClickListener,
        GoogleMap.OnMyLocationButtonClickListener{


    private final static int MY_PERMISSION_FINE_LOCATION = 101;
    private GoogleMap mMap;
    private LocationManager locationManager;
    public MapsFragment() {
    }

    public static MapsFragment newInstance() {
        return new MapsFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mapView = inflater.inflate(R.layout.activity_map, container, false);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return mapView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap = googleMap;
            mMap.setMyLocationEnabled(true);
            mMap.setOnMyLocationButtonClickListener(this);
            mMap.setOnMyLocationClickListener(this);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_FINE_LOCATION);
                mMap = googleMap;
                mMap.setOnMyLocationButtonClickListener(this);
                mMap.setOnMyLocationClickListener(this);
            }

        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }
}