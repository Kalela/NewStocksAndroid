package com.kalela.philipkalela.newstock.feature.all_users_dashboard.presenter;

import android.util.Log;

import com.kalela.philipkalela.newstock.feature.all_users_dashboard.contract.UsersContract;
import com.kalela.philipkalela.newstock.feature.all_users_dashboard.model.Users;
import com.kalela.philipkalela.newstock.feature.utils.service.AuthService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersPresenter {
    UsersContract.UsersView view;
    private final AuthService authService;

    public UsersPresenter(UsersContract.UsersView view, AuthService authService) {
        this.authService = authService;
        this.view = view;
    }

    public void initDataSet() {
        authService.getUsers().enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(Call<ArrayList<Users>> call, Response<ArrayList<Users>> response) {
                if (response.isSuccessful()) {
                    view.displayUsers( response.body() );
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Users>> call, Throwable t) {
                Log.e("check", "onFailure: " + t.getLocalizedMessage());
                view.showErrorMessage();
            }
        });
    }
}
