package com.kalela.philipkalela.newstock.feature.main_dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kalela.philipkalela.newstock.feature.all_users_dashboard.AllUsersActivity;
import com.kalela.philipkalela.newstock.feature.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// TODO: Binding
//        ActivityMainBinding activityMainBinding = DataBindingUtil
//                .setContentView(this, R.layout.activity_main);

        TextView allUsersTextView = findViewById(R.id.allUsersTextView);
        allUsersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllUsers();
            }
        });
    }

    private void showAllUsers() {
        Intent allUsers = new Intent(this, AllUsersActivity.class);
        startActivity(allUsers);
    }
}
