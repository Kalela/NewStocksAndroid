package com.kalela.philipkalela.newstock.feature.register.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.kalela.philipkalela.newstock.feature.register.contract.RegisterContract;
import com.kalela.philipkalela.newstock.feature.register.model.RegisterUser;
import com.kalela.philipkalela.newstock.feature.utils.service.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {
    RegisterContract.RegisterView view;
    private final AuthService authService;

    public RegisterPresenter(RegisterContract.RegisterView view, AuthService authService) {
        this.view = view;
        this.authService = authService;
    }

    public void registerUser(String email, String name,  String username, String phone, String password, String confirmPassword) {
        password = password.intern();
        confirmPassword = confirmPassword.intern();

        RegisterUser user = new RegisterUser.Builder()
                .setConfirmPassword(confirmPassword)
                .setPassword(password)
                .setUsername(username)
                .setEmail(email)
                .setName(name)
                .setPhone(phone)
                .build();

        Log.d("check", "registerUser: user model = " + user.getUsername());

        if (password == confirmPassword) {
            authService.postUser(user).enqueue(new Callback<String>() {
                @Override
                public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                    if (response.isSuccessful()) {
                        view.navigateSuccess();
                    } else {
                        view.showErrorMessage();
                    }

                }

                @Override
                public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                    view.showErrorMessage();
                }
            });
        } else {
            view.showPasswordToast();
        }
    }
}
