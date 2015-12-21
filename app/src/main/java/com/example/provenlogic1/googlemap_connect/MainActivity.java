package com.example.provenlogic1.googlemap_connect;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

    private final LatLng local1 = new LatLng(-38.7519663, -72.6174443);
    private final LatLng local2 = new LatLng(-38.744319, -72.616394);
    private final LatLng local3 = new LatLng(-38.7375426, -72.5960242);
    private final LatLng local4 = new LatLng(-38.7377292, -72.5947111);
    private final LatLng local5 = new LatLng(-38.7378658, -72.5917302);
    private final LatLng local6 = new LatLng(-38.7265815, -72.6274266);
    private final LatLng local7 = new LatLng(-38.7373843, -72.5992395);
    private final LatLng local8 = new LatLng(-38.7422257,-72.5908917);
    private final LatLng local9 = new LatLng(-38.7413169,-72.5892867);
    private final LatLng local10 = new LatLng(-38.7371924,-72.6258121);
    private final LatLng local11 = new LatLng(-38.7370668,-72.6215284);
    private final LatLng local12 = new LatLng(-38.7372329,-72.5920603);
    private final LatLng local13 = new LatLng(-38.7387256,-72.6180388);
    private final LatLng local14 = new LatLng(-38.7389389,-72.5887743);
    private final LatLng local15 = new LatLng(-38.7408376,-72.5918591);
    private final LatLng local16 = new LatLng(-38.728479,-72.580046);
    private final LatLng local17 = new LatLng(-38.7300962,-72.5823204);
    private final LatLng local18 = new LatLng(-38.7300962,-72.5823204);
    private final LatLng local19 = new LatLng(-38.7409697,-72.6195933);
    private final LatLng local20 = new LatLng(-38.7408646,-72.619536);
    private final LatLng local21 = new LatLng(-38.7432855,-72.615449);
    private final LatLng local22 = new LatLng(-38.7434153,-72.6341119);
    private final LatLng local23 = new LatLng(-38.7491022,-72.6159197);
    private final LatLng local24 = new LatLng(-38.7446359,-72.6187709);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        try {
            // Loading map
            initilizeMap();


            double latitude = 0;
            double longitude = 0;
            GPSTracker gps;
            gps = new GPSTracker(this);
            if(gps.canGetLocation()){
                latitude=gps.getLatitude();
                longitude=gps.getLongitude();
                LatLng UPV = new LatLng(latitude, longitude);
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UPV, 15));

            }else{
                gps.showSettingsAlert();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**function to load map If map is not created it will create it for you **/

    GoogleMap googleMap;
    private void initilizeMap() {

        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            // Showing / hiding your current location
            googleMap.setMyLocationEnabled(true);

            // Enable / Disable zooming controls
            googleMap.getUiSettings().setZoomControlsEnabled(true);

            // Enable / Disable my location button
            googleMap.getUiSettings().setMyLocationButtonEnabled(true);

            // Enable / Disable Compass icon
            googleMap.getUiSettings().setCompassEnabled(true);

            // Enable / Disable Rotate gesture
            googleMap.getUiSettings().setRotateGesturesEnabled(true);

            // Enable / Disable zooming functionality
            googleMap.getUiSettings().setZoomGesturesEnabled(true);

            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }


            googleMap.addMarker(new MarkerOptions()
                    .position(local1)
                    .title("La Barricada")
                    .snippet("Fono: 749933 ")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local2)
                    .title("La Picá de Uruguay")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local3)
                    .title("Al Paso")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local4)
                    .title("Cocosandwich")
                    .snippet("Fono: 649595 - 740808  Despacho a domicilio")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local5)
                    .title("Chile Sandwich")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local6)
                    .title("After sandwich")
                    .snippet("Fono:  ")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local7)
                    .title("Tao's Sandwich & Bocatas")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local8)
                    .title("Kokomo delivery")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local9)
                    .title("La picada de Mackenna")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local10)
                    .title("Club sandwich")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local11)
                    .title("Club sandwich")
                    .snippet("Fono:  ")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local12)
                    .title("Charly dog")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local13)
                    .title("El Toltén")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local14)
                    .title("Media luna")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local15)
                    .title("La Bóveda")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local16)
                    .title("Las Muñecas del Ñielol")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local17)
                    .title("Zuny Tradiciones")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local18)
                    .title("Sangucheria Caupolican")
                    .snippet("Fono:  ")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local19)
                    .title("El Horno de Mama Elba")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local20)
                    .title("Enkai Delivery")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local21)
                    .title("Kimi Su Shi")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local22)
                    .title("Sushi Hasu Delivery")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local23)
                    .title("Sandwich Al Paso")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));
            googleMap.addMarker(new MarkerOptions()
                    .position(local24)
                    .title("Tepano´s")
                    .snippet("Fono:")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.burger))
                    .anchor(0.5f, 0.5f));



        }
    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ranking) {
            // Handle the camera action
        } else if (id == R.id.visitados) {

        } else if (id == R.id.favoritos) {



        } else if (id == R.id.salir) {



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
