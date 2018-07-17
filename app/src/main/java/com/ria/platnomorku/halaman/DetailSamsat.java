package com.ria.platnomorku.halaman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ria.platnomorku.R;
import com.ria.platnomorku.database.SqliteHelper;

public class DetailSamsat extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String title;
    private double lat, lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_samsat);

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String nama = getIntent().getStringExtra(SqliteHelper.FIELD_NAMA);
        String lat = getIntent().getStringExtra(SqliteHelper.FIELD_LAT);
        String lon = getIntent().getStringExtra(SqliteHelper.FIELD_LON);
        String email = "Email: " + getIntent().getStringExtra(SqliteHelper.FIELD_EMAIL);
        String alamat = "Alamat: " + getIntent().getStringExtra(SqliteHelper.FIELD_ALAMAT);
        String telp = "Telp: " + getIntent().getStringExtra(SqliteHelper.FIELD_TELP);

        this.title = nama;
        this.lat = Double.parseDouble(lat);
        this.lon = Double.parseDouble(lon);

        setTitle(title);

        TextView textViewNama = findViewById(R.id.nama);
        TextView textViewEmail = findViewById(R.id.email);
        TextView textViewAlamat = findViewById(R.id.alamat);
        TextView textViewTelp = findViewById(R.id.telp);

        textViewNama.setText("Nama: " + nama);
        textViewEmail.setText(email);
        textViewAlamat.setText(alamat);
        textViewTelp.setText(telp);

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

        LatLng sydney = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(sydney).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
