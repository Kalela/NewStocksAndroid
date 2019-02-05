package com.kalela.philipkalela.newstock.feature.utils.service;

import com.kalela.philipkalela.newstock.feature.all_users_dashboard.model.Users;
import com.kalela.philipkalela.newstock.feature.register.model.RegisterUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AuthService {
    @GET("users")
    Call<ArrayList<Users>> getUsers();

    @POST("users")
    Call<String> postUser(@Body RegisterUser user);
}
