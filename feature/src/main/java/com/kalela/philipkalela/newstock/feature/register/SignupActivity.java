package com.kalela.philipkalela.newstock.feature.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kalela.philipkalela.newstock.feature.R;
import com.kalela.philipkalela.newstock.feature.login.LoginActivity;

public class SignupActivity extends AppCompatActivity {
    TextView gotToSignInLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gotToSignInLink = findViewById(R.id.signUpToSignInLinkTextView);
        gotToSignInLink.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
