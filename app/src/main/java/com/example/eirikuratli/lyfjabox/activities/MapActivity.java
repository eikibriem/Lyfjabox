package com.example.eirikuratli.lyfjabox.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.eirikuratli.lyfjabox.R;
import com.google.android.gms.instantapps.LaunchData;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    //Will display pharmacies on a map along with user location, if a marker is clicked it will open a information window
    //where some information about the selected pharmacy will be available

    private GoogleMap mMap;
    private LatLng latLngLOHAusturver;
    private int zoomLevel;
    private LatLng latLngLOHHringbraut;
    private LatLng latLngApotekarinnSkeifa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        zoomLevel = 10;

        LatLng latLngLOHAusturver = new LatLng(64.1283277, -21.886857700000064);
        mMap.addMarker(new MarkerOptions().position(latLngLOHAusturver).title("Lyf og heilsa - Austurveri"));

        LatLng latLngLOHHringbraut = new LatLng(64.15075139999999, -21.960721499999977);
        mMap.addMarker(new MarkerOptions().position(latLngLOHHringbraut).title("Lyf og heilsa - Hringbraut"));

        LatLng latLngApotekarinnMjodd = new LatLng(64.1088046, -21.843144100000018);
        mMap.addMarker(new MarkerOptions().position(latLngApotekarinnMjodd).title("Apótekarinn - Mjódd"));

        //CameraPosition position = new CameraPosition(latLngLOHAusturver, 12, 0, 0);
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngLOHAusturver, 5));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngApotekarinnMjodd, zoomLevel));
    }

}
