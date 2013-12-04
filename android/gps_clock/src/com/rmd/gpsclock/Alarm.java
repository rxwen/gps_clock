package com.rmd.gpsclock;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.location.LocationManager;
import android.location.Location;
import android.util.Log;

public class Alarm extends Activity
{

    static String LOG_TAG = "Main";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        boolean is_enter_area = this.getIntent().getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
        //boolean is_enter_area = savedInstanceState.getBoolean(
        Log.d(LOG_TAG, String.format("is_enter_area is %b", is_enter_area));
    }

}
