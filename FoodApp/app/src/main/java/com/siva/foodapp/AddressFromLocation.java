package com.siva.foodapp;

/**
 * Created by pvijapur on 06/11/16.
 */
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class AddressFromLocation {
    private static final String TAG = "LocationAddress";
    static Thread mLocateMeThread;
    public static void getAddressFromLocation(final double latitude, final double longitude,
                                              final Context context, final Handler handler) {
        mLocateMeThread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                Address address = null;
                try {
                    Log.e("TAG", "Pavan GPS getAddressFromLocation inside it ");

                    List<Address> addressList = geocoder.getFromLocation(
                            latitude, longitude, 1);
                    if (addressList != null && addressList.size() > 0) {
                        address = addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                            sb.append(address.getAddressLine(i)).append("\n");
                        }
                        sb.append(address.getLocality()).append("\n");
                        sb.append(address.getPostalCode()).append("\n");
                        sb.append(address.getCountryName());
                        result = sb.toString();
                    }

                    Log.e("TAG", "Pavan GPS getAddressFromLocation inside here ");

                } catch (IOException e) {
                    Log.e(TAG, "Unable connect to Geocoder", e);
                } finally {

                    Log.e("TAG", "Pavan GPS getAddressFromLocation inside here finally man");

                    Message message = Message.obtain();
                    message.setTarget(handler);
                    if (result != null) {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Latitude: " + latitude + " Longitude: " + longitude +
                                "\n\nAddress:\n" + result;
                        bundle.putString("address", result);
                        bundle.putString("locality", address.getLocality());
                        bundle.putString("postalCode", address.getPostalCode());
                        bundle.putString("sublocality", address.getSubLocality());

                        message.setData(bundle);
                    } else {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Latitude: " + latitude + " Longitude: " + longitude +
                                "\n Unable to get address for this lat-long.";
                        bundle.putString("address", result);
                        message.setData(bundle);
                    }
                    if(!mLocateMeThread.isInterrupted()) {
                        Log.e("TAG", "Pavan GPS getAddressFromLocation inside here isInterrupted");

                        message.sendToTarget();
                    }
                }
            }
        };
        mLocateMeThread.start();
    }
}