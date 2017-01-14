package com.siva.foodapp.rest;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

import static com.siva.foodapp.rest.ApiUrls.BASE_URL;

/**
 * Created by sarumugam on 13/01/17.
 */

public class RetrofitClient {

    private static Retrofit mRetrofit;

    private RetrofitClient(){
        OkHttpClient client = new OkHttpClient();
        client.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        });

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(logging);
        mRetrofit = new Retrofit.Builder()
                .baseUrl("http://182.156.77.170:8081")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

    public static Retrofit getRetroClient() {
        if(mRetrofit == null){
            new RetrofitClient();
        }
        return mRetrofit;
    }
}