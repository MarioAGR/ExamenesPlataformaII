package com.example.marioagr.u4_examen1;

import android.annotation.SuppressLint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

	private GoogleMap mMap;
	LocationManager locManager;

	Button btn;
	double latitud = 0, longitud = 0;
	int numMarcador = 1;
	boolean botonBool = false;

	Thread hilo;

//	carbon-clover-188201

	@SuppressLint("MissingPermission")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
		btn = (Button) findViewById(R.id.btn);
		locManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		Criteria criterio = new Criteria();
		String proveedor = locManager.getBestProvider(criterio, true);
		Location locacion = locManager.getLastKnownLocation(proveedor);
		if (locacion != null) {
			onLocationChanged(locacion);
		}
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

		// Add a marker in Sydney and move the camera
		LatLng sydney = new LatLng(-34, 151);
		mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
		mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//		cont = new Contador();
	}

	@Override
	public void onLocationChanged(Location location) {
		latitud = location.getLatitude();
		longitud = location.getLongitude();
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

	public void enClick(View v) {
		agregarMarcador();
		botonBool = !botonBool;
		if (botonBool) {
			btn.setText("Detener");
		} else {
			btn.setText("Detenido");
		}
	}

	public void agregarMarcador() {
		numMarcador++;
		LatLng marcador = new LatLng(latitud, longitud);
		mMap.addMarker(new MarkerOptions().position(marcador).title("Marcador #" + numMarcador));
	}

	//	Agregar un AsyncTask o algo para manejar con tiempo y de ahi darle a los 20 segundos

}
