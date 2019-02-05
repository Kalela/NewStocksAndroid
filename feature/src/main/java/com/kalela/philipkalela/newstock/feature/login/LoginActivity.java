package com.kalela.philipkalela.newstock.feature.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kalela.philipkalela.newstock.feature.R;
import com.kalela.philipkalela.newstock.feature.register.view.SignupActivity;

public class LoginActivity extends AppCompatActivity {
    TextView gotToSignUpLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        gotToSignUpLink = findViewById(R.id.signInToSignUpLinkTextView);
        gotToSignUpLink.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}
