package com.siva.foodapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LocationActivity extends AppCompatActivity {

    private TextInputLayout mCityHolder,mLocationHolder;
    private EditText mCityBox,mLocationBox;
    private Button mLocateButton;
    private ImageView mNavigateBackButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        initializeViews();
        initializeListeners();
    }

    private void initializeViews() {
        mCityHolder = (TextInputLayout) findViewById(R.id.city_box_holder);
        mLocationHolder = (TextInputLayout) findViewById(R.id.location_box_holder);
        mCityBox = (EditText) findViewById(R.id.city_box);
        mLocationBox = (EditText) findViewById(R.id.location_box);
        mLocateButton = (Button) findViewById(R.id.locate_button);
        mNavigateBackButton = (ImageView) findViewById(R.id.navigate_back);
    }

    private void initializeListeners(){
        mLocateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mCityHolder.setError("Whats up?");
            }
        });

        mNavigateBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
