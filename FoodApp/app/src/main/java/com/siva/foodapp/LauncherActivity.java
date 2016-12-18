package com.siva.foodapp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.siva.foodapp.AddressFromLocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by pvijapur on 07/11/16.
 */
public class LauncherActivity extends AppCompatActivity implements LocationListener {

    private static final String TAG = "LauncherActivity";
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private final int FETCHING_CURRENT_LOCATION = 4000;

    protected LocationManager locationManager;
    Location location;
    private boolean isGPSEnabled = false;
    private boolean isPermissionProvided = false;
    String locationAddress = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                handlePermission(LauncherActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }
        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (grantResults[0] == 0) {
            isPermissionProvided = true;
            enableGPS();
        } else {
            isPermissionProvided = false;
            goToNextActivity(null, null, null);
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public boolean isPermissionCheckRequired() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public boolean handlePermission(Activity context, String[] permissions, int requestCode) {
        boolean isToBeHandled = false;
        Log.d(TAG, "Runtime permission handling is required : " + isPermissionCheckRequired());
        if (isPermissionCheckRequired()) {
            String[] neededPermissions = getUnhandledPermissions(context, permissions);
            if (neededPermissions.length > 0) {
                Log.d(TAG, "Need permissions from user.");
                isToBeHandled = true;
                // Request the permission. The result will be received in onRequestPermissionResult()
                ActivityCompat.requestPermissions(context, neededPermissions, requestCode);
            } else {
                isPermissionProvided = true;
                enableGPS();
                Log.d(TAG, "All Requested permissions are available.");
            }
        } else {
            isPermissionProvided = true;
            enableGPS();
        }
        return isToBeHandled;
    }

    boolean isGPSEnablement = false;

    private void enableGPS() {
        locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);

        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Your GPS seems to be disabled, Help us locate you by enabling it ")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            isGPSEnablement = true;
                            startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                            isGPSEnabled = false;
                            dialog.cancel();
                            goToNextActivity(null, null, null);
                        }
                    });
            final AlertDialog alert = builder.create();
            alert.show();
        } else {
            isGPSEnabled = true;
            Log.e("TAG", "Pavan GPS getLocationAddress called ");
            getLocationAddress();
        }
    }

    @Override
    protected void onResume() {
        if (isGPSEnablement) {
            isGPSEnablement = false;
            if (locationManager != null && isPermissionProvided == true) {
                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    isGPSEnabled = true;
                    Log.e("TAG", "Pavan GPS getLocationAddress onResume");
                    getLocationAddress();
                } else {
                    isGPSEnabled = false;
                    goToNextActivity(locality, mSubLocality, locationAddress);

                }
            }
        }
        super.onResume();
    }

    Handler pdCanceller;
    Runnable progressRunnable;
    ProgressDialog dialog;
    Timer timer;
    GeocoderHandler mGeocoderHandler = new GeocoderHandler();

    private boolean getLocationAddress() {
        Log.e("TAG", "Pavan GPS getLocationAddress");


        dialog = new ProgressDialog(LauncherActivity.this);
        dialog.setTitle("Loading...");
        dialog.setMessage("Please wait while we fetch current location ");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();

        long delayInMillis = 13000;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dismiss();
                Log.e("TAG", "Pavan timer out ");
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                if(null != locationManager)
                    locationManager.removeUpdates(LauncherActivity.this);
                goToNextActivity(locality, mSubLocality, locationAddress);
            }
        }, delayInMillis);

        if (locationManager != null) {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.e("TAG", "Pavan Location access is not present ");
                return false;
            }

            Log.e("TAG", "Pavan GPS need tobe on ");
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0, this);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1, 0, this);

        }
        return true;
    }

    private static String[] getUnhandledPermissions(Activity context, String[] permissions) {
        List<String> permissionList = new ArrayList<>();
        Collections.addAll(permissionList, permissions);
        for (int i = 0; i < permissionList.size(); ) {
            if (TextUtils.isEmpty(permissionList.get(i))) {
                permissionList.remove(permissionList.get(i));
                continue;
            }
            if (ContextCompat.checkSelfPermission(context, permissionList.get(i)) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "Requested permission is available.");
                permissionList.remove(permissionList.get(i));
            } else {
                i++;
            }
        }

        return permissionList.toArray(new String[permissionList.size()]);
    }


    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "Pavan onLocationChanged");

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    public void requestPermissions(@NonNull String[] permissions, int requestCode)
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            Log.d(TAG, "Pavan onLocationChanged returning ");
            return;
        }
        locationManager.removeUpdates(this);
        AddressFromLocation.getAddressFromLocation(location.getLatitude(), location.getLongitude(), getApplicationContext(), new GeocoderHandler());
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

    //String locationAddress = null;
    String City = null;
    String postalCode = null;
    String mSubLocality = null;
    String locality = null;

    void goToNextActivity(String City, String Area, String locationAddress) {
        Intent intent = new Intent(LauncherActivity.this,LocationActivity.class);
        intent.putExtra("City", City);
        intent.putExtra("Area", Area);
        intent.putExtra("Address", locationAddress);
        startActivity(intent);
        mGeocoderHandler.removeMessages(1);
        finish();
    }

    class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            timer.cancel();
            switch (message.what) {
                case 1:
                    Log.e("TAG", "Pavan GPS message received ");
                    Log.e("TAG", "GPS message received");

                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    mSubLocality = bundle.getString("sublocality");
                    postalCode = bundle.getString("postalCode");
                    locality = bundle.getString("locality");
                    dialog.dismiss();
                    break;
                default:
                    locationAddress = null;
            }
            goToNextActivity(locality, mSubLocality, locationAddress);
            if(null == locality || null == mSubLocality)
                Toast.makeText(getApplicationContext(), "Oops! We're unable to fetch your Location", Toast.LENGTH_SHORT).show();
            //Toast.makeText(getApplicationContext(), "Current Location : \n \n" + "City " + locality +"\nArea " + mSubLocality + "\nPostal Code " + postalCode, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(), "locationAddress" + locationAddress, Toast.LENGTH_SHORT).show();
            Log.e("TAG", "GPS " + "City " + locality + " SubLocality " + mSubLocality + "Postal Code " + postalCode);
        }
    }
}