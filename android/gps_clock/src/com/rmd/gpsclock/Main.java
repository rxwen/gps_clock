package com.rmd.gpsclock;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.location.LocationManager;
import android.location.LocationListener;
import android.location.Location;
import android.util.Log;
import android.app.PendingIntent;
import android.content.Intent;

public class Main extends Activity
{

    static String LOG_TAG = "Main";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        m_longitude = (EditText)findViewById(R.id.longitude);
        m_latitude = (EditText)findViewById(R.id.latitude);

        m_longitude.setText("aa");
        m_latitude.setText("bb");

        m_locmgr = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        Intent intent = new Intent(this, Alarm.class);
        PendingIntent pintent = PendingIntent.getActivity(this, 0, intent, 0);
        m_locmgr.addProximityAlert(31.200, 121.406, 100000, -1, pintent);
        m_loclistener = new LocationListener() {
            public void onLocationChanged(Location location) {
                Log.d(LOG_TAG, location.toString());
                m_longitude.setText(String.valueOf(location.getLongitude()));
                m_latitude.setText(String.valueOf(location.getLatitude()));
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d(LOG_TAG, provider);
            }

            public void onProviderEnabled(String provider) {
                Log.d(LOG_TAG, "enabled");
                Log.d(LOG_TAG, provider);
            }

            public void onProviderDisabled(String provider) {
                Log.d(LOG_TAG, "disabled");
                Log.d(LOG_TAG, provider);
            }
        };

        //m_locmgr.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                //0, 0, m_loclistener);
        //m_locmgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                //0, 0, m_loclistener);

    }

    EditText m_longitude;
    EditText m_latitude;
    LocationManager m_locmgr;
    LocationListener m_loclistener;
}
