package br.ufc.dc.sd4mp.mymap;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MyMap extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,SensorEventListener {

    private GoogleMap googleMap;
    private GoogleApiClient googleApiClient;
    private TextView addressLabel;
    private TextView locationLabel;
    private SensorManager manager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_map);
        initMap();

        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);

        this.addressLabel = (TextView) findViewById(R.id.textView2);
        this.locationLabel = (TextView) findViewById(R.id.textView);

        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this);
        builder.addApi(LocationServices.API);
        builder.addConnectionCallbacks(this);
        builder.addOnConnectionFailedListener(this);
        googleApiClient = builder.build();
    }

    private void initMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            } else {
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        float temperatura = event.values[0];
        Toast.makeText(this,"Temperatura: " + temperatura, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Conectado!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int value) {
        Toast.makeText(this, "Desconectado!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Toast.makeText(this, "Conexão Falhou...", Toast.LENGTH_LONG).show();
    }

    public void getLocation(View view) {
        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        String text = "Localização:<" + location.getLatitude() + "," + location.getLongitude() + ">";
        locationLabel.setText(text);
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        GetAddressTask task = new GetAddressTask(this);
        task.execute(location);
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("You are here!");
        googleMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latitude, longitude)).zoom(16).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    protected void onPause() {
        super.onPause();
        manager.unregisterListener(this);
    }

    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
        initMap();
    }

    private class GetAddressTask extends AsyncTask<Location, Void, String> {
        private Context context;

        public GetAddressTask(Context context) {
            super();
            this.context = context;
        }

        @Override
        protected void onPostExecute(String address) {
            addressLabel.setText(address);
        }

        @Override
        protected String doInBackground(Location... params) {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            Location location = params[0];
            List<Address> addresses = null;
            try {
                addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            } catch (IOException ioe) {
                Log.e("GetAddressTask", "IO Exception in getFromLocation()");
                ioe.printStackTrace();
                return "IO Exception trying to get address";
            } catch (IllegalArgumentException iae) {
                String errorString = "Illegal arguments " + Double.toString(location.getLatitude()) + " , " + Double.toString(location.getLongitude()) + " passed to address service";
                Log.e("GetAddressTask", errorString);
                iae.printStackTrace();
                return errorString;
            }
            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                String addressText = address.getAddressLine(0) + ", " + address.getAdminArea() + ", " + address.getCountryCode();
                return addressText;
            } else {
                return "No address found!";
            }
        }
    }
}

