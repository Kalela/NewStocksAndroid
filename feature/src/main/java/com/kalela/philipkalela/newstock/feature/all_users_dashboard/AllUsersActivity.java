package com.kalela.philipkalela.newstock.feature.all_users_dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kalela.philipkalela.newstock.feature.all_users_dashboard.adapter.UsersAdapter;
import com.kalela.philipkalela.newstock.feature.all_users_dashboard.contract.UsersContract;
import com.kalela.philipkalela.newstock.feature.all_users_dashboard.model.Users;
import com.kalela.philipkalela.newstock.feature.all_users_dashboard.presenter.UsersPresenter;
import com.kalela.philipkalela.newstock.feature.all_users_dashboard.service.Injector;
import com.kalela.philipkalela.newstock.feature.R;

import java.util.ArrayList;

public class AllUsersActivity extends AppCompatActivity implements UsersContract.UsersView {

    RecyclerView recyclerView;
    UsersAdapter usersAdapter;
    ArrayList<Users> users;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        recyclerView = findViewById(R.id.usersRecyclerView);

        UsersPresenter usersPresenter = new UsersPresenter(this, Injector.provideUsersService());
        usersAdapter = new UsersAdapter(this, users);
        usersPresenter.initDataSet();
    }

    @Override
    public void displayUsers(ArrayList<Users> userList) {
        users = userList;
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter adapter = new UsersAdapter(this, users);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText( this, R.string.users_loading_unsuccessful, Toast.LENGTH_SHORT).show();
    }
}
