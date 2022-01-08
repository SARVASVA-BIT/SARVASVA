package com.example.sarvasva.app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sarvasva.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.Objects;

public class GoogleMapsInSarvasva extends AppCompatActivity {


    private FusedLocationProviderClient client;
    private SupportMapFragment mapFragment;
    private int REQUEST_CODE=111;


    //private Toolbar GoogleMap = findViewById(R.id.Google_Map);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps_in_sarvasva);

        //setupActionBar();
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        String title = "MAP";
//        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary)));




        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        //String title =  "MAPS";
        //getActionBar().getTitle(title);
        client = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                &&  ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
        ) {
            //Toast.makeText(getContext() , "LOCation granted" , Toast.LENGTH_LONG).show();
            getCurrentLocation();
        }
        else{
            ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        } else {
            Toast.makeText(this, "PERMISSION DINIED", Toast.LENGTH_LONG).show();
        }
    }


    private void getCurrentLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        Toast.makeText(this , "Location permission accepted" , Toast.LENGTH_SHORT).show();
        client.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>(){
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    mapFragment.getMapAsync(googleMap -> {
                        LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
                        MarkerOptions markerOptions = new MarkerOptions().position(latlng).title("YOU ARE HERE");

                        //Toast.makeText(this, "locationgetLongitude", Toast.LENGTH_LONG).show();
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15));

                        googleMap.addMarker(markerOptions).showInfoWindow();
                    });
                } else {
                    Toast.makeText(GoogleMapsInSarvasva.this, "Please turn on your GPS", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

//
//    public void setupActionBar(){
//        setSupportActionBar(GoogleMap);
//        ActionBar actionBar =null;
//        if(actionBar!=null){
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
//        }
//        GoogleMap.setNavigationOnClickListener(view -> {
//            {
//                Intent intent1 = new Intent(GoogleMapsInSarvasva.this , MainActivity.class);
//                startActivity(intent1);
//                finish();
//            }
//        });
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == android.R.id.home)
//        {
//            this.finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }

}