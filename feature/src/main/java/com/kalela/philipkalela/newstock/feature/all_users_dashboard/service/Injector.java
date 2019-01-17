package com.kalela.philipkalela.newstock.feature.all_users_dashboard.service;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injector {
    public static Retrofit provideRetrofit(String baseUrl) {
        Log.d("check", "base url: " + baseUrl);
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static UsersService provideUsersService() {
        return provideRetrofit("https://new-stock-spring-api.herokuapp.com//api/v1/").create(UsersService.class);
    }
}
