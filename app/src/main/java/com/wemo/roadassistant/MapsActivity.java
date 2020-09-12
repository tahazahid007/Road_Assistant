//https://www.youtube.com/watch?v=p0PoKEPI65o
package com.wemo.roadassistant;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.wemo.database.MyDBHandler;

public class MapsActivity extends FragmentActivity implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        context = this;
        initializing();
        mapFragment.getMapAsync(this);
    }

    private void initializing() {
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        client = LocationServices.getFusedLocationProviderClient(this);
        checkUserPermission();
    }

    private void checkUserPermission() {
        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        }
        else {
            ActivityCompat.requestPermissions(MapsActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    44);
        }
    }

    private void getCurrentLocation() {
        @SuppressLint("MissingPermission")
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(final Location location) {
                if(location != null){
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            MyDBHandler myDBHandler = new MyDBHandler(context);
                            for (int i = 0; i < myDBHandler.getAllLatLang().size(); i++) {
                                Log.d("Test", "onMapReady: " + myDBHandler.getAllLatLang().get(i).getLatitude()+"......"+myDBHandler.getAllLatLang().get(i).getLongitude());
                                LatLng latLng = new LatLng(Double.parseDouble(myDBHandler.getAllLatLang().get(i).getLatitude()),
                                        Double.parseDouble(myDBHandler.getAllLatLang().get(i).getLongitude()));
                                MarkerOptions markerOptions = new MarkerOptions()
                                        .position(latLng)
                                        .title(myDBHandler.getAllLatLang().get(i).getShopName());

                                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
                                googleMap.addMarker(markerOptions);
                            }
                        }
                    });
                }
            }
        });
    }
    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        /*mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        mMap = googleMap;

        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 44){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getCurrentLocation();
            }
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }
}