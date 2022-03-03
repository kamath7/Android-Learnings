package com.example.kamathinc.favoriteplaces;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;


    public void centerMapOnUserLoc(Location location, String title) {

        if(location != null){
            LatLng userLoc = new LatLng(location.getLatitude(), location.getLongitude());
            mMap.clear();
            mMap.addMarker(new MarkerOptions().position(userLoc).title(title));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLoc, 7));
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                Location lastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                centerMapOnUserLoc(lastLocation, "Current Location👇");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(this);

        Intent intent = getIntent();
//        Toast.makeText(getApplicationContext(), Integer.toString(intent.getIntExtra("placeId",0)), Toast.LENGTH_SHORT).show();


        if (intent.getIntExtra("placeId", 0) == 0) {
            //move to user loc
            locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    centerMapOnUserLoc(location, "Current Location👇");
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            };

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                Location lastLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                centerMapOnUserLoc(lastLocation, "Current Location👇");

            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }
        }else{
            Location someLoc = new Location(LocationManager.NETWORK_PROVIDER);
            someLoc.setLatitude(MainActivity.locations.get(intent.getIntExtra("placeId", 0)).latitude);
            someLoc.setLongitude(MainActivity.locations.get(intent.getIntExtra("placeId", 0)).longitude);

            centerMapOnUserLoc(someLoc, MainActivity.favPlaces.get(intent.getIntExtra("placeId", 0)));

        }

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

        Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault() );
        String address = "";
        try{
            List<Address> addressList = geocoder.getFromLocation(latLng.latitude, latLng.longitude,1);
            if(addressList!=null && addressList.size() > 0){
                if(addressList.get(0).getThoroughfare() !=null){
                    if (addressList.get(0).getSubThoroughfare() !=null){
                        address+= addressList.get(0).getSubThoroughfare() +" ";
                    }
                    address+= addressList.get(0).getThoroughfare();
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        if(address.equals("")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            address+= simpleDateFormat.format(new Date());
        }
        mMap.addMarker(new MarkerOptions().position(latLng).title("Your new place! "));

        MainActivity.favPlaces.add(address);
        MainActivity.locations.add(latLng);

        MainActivity.arrayAdapter.notifyDataSetChanged();

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.kamathinc.favoriteplaces", Context.MODE_PRIVATE);

        try{
            ArrayList<String> latitudes = new ArrayList<>();
            ArrayList<String> longitudes = new ArrayList<>();

            for (LatLng cords : MainActivity.locations){
                latitudes.add(Double.toString(cords.latitude));
                longitudes.add(Double.toString(cords.longitude));
            }
            sharedPreferences.edit().putString("places",ObjectSerializer.serialize(MainActivity.favPlaces)).apply();
            sharedPreferences.edit().putString("Latitudes",ObjectSerializer.serialize(latitudes)).apply();
            sharedPreferences.edit().putString("Longitudes",ObjectSerializer.serialize(longitudes)).apply();
        }catch(Exception e){
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Location added!", Toast.LENGTH_SHORT).show();
    }
}
