//package com.example.sarvasva.app.activities;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.example.sarvasva.R;
//import com.google.android.gms.location.FusedLocationProviderClient;
//import com.google.android.gms.location.LocationServices;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.tasks.OnSuccessListener;
//
//public class GoogleMapsInSarvasva extends AppCompatActivity {
//
//    private FusedLocationProviderClient client;
//    private SupportMapFragment mapFragment;
//    private int REQUEST_CODE=111;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_google_maps_in_sarvasva);
//
//        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
//
//        client = LocationServices.getFusedLocationProviderClient(this);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
//                &&  ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
//        ) {
//            //Toast.makeText(getContext() , "LOCation granted" , Toast.LENGTH_LONG).show();
//            getCurrentLocation();
//        }
//        else{
//            ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
//        }
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                getCurrentLocation();
//            }
//        } else {
//            Toast.makeText(this, "PERMISSION DINIED", Toast.LENGTH_LONG).show();
//        }
//    }
//
//
//    private void getCurrentLocation() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//            return;
//        }
//        Toast.makeText(this , "Location granted" , Toast.LENGTH_LONG).show();
//        client.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>(){
//            @Override
//            public void onSuccess(Location location) {
//                if (location != null) {
//                    mapFragment.getMapAsync(googleMap -> {
//                        LatLng latlng = new LatLng(location.getLatitude(), location.getLongitude());
//                        MarkerOptions markerOptions = new MarkerOptions().position(latlng).title("YOU ARE HERE");
//
//                        //Toast.makeText(this, "locationgetLongitude", Toast.LENGTH_LONG).show();
//                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15));
//
//                        googleMap.addMarker(markerOptions).showInfoWindow();
//                    });
//                } else {
//                    //Toast.makeText(this, "No Location Found", Toast.LENGTH_LONG).show();
//                }
//            }
//
//        });
//    }
//}