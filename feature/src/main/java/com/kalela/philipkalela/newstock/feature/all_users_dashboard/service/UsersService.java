package com.kalela.philipkalela.newstock.feature.all_users_dashboard.service;

import com.kalela.philipkalela.newstock.feature.all_users_dashboard.model.Users;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersService {
    @GET("users")
    Call<ArrayList<Users>> getUsers();
}
