package com.kalela.philipkalela.newstock.feature.all_users_dashboard.contract;

import com.kalela.philipkalela.newstock.feature.all_users_dashboard.model.Users;

import java.util.ArrayList;

public interface UsersContract {

    interface UsersView {
        void displayUsers(ArrayList<Users> userList);

        void showErrorMessage();
    }
}
