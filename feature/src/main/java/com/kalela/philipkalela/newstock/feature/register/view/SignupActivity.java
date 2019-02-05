package com.kalela.philipkalela.newstock.feature.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kalela.philipkalela.newstock.feature.R;
import com.kalela.philipkalela.newstock.feature.login.LoginActivity;
import com.kalela.philipkalela.newstock.feature.register.contract.RegisterContract;
import com.kalela.philipkalela.newstock.feature.register.model.RegisterUser;
import com.kalela.philipkalela.newstock.feature.register.presenter.RegisterPresenter;
import com.kalela.philipkalela.newstock.feature.utils.injection.RetrofitInjector;

public class SignupActivity extends AppCompatActivity implements RegisterContract.RegisterView {
    TextView gotToSignInLink;
    EditText fullName;
    EditText email;
    EditText username;
    EditText password;
    EditText phone;
    EditText confirmPassword;
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final RegisterPresenter registerPresenter = new RegisterPresenter(this,
                RetrofitInjector.provideUsersService());

        gotToSignInLink = findViewById(R.id.signUpToSignInLinkTextView);
        fullName = findViewById(R.id.signupFullNameEditText);
        email = findViewById(R.id.signupEmailEditText);
        username = findViewById(R.id.signupUsernameEditText);
        password = findViewById(R.id.signUpPasswordEditText);
        phone = findViewById(R.id.signupPhoneEditText);
        confirmPassword = findViewById(R.id.signupConfirmPasswordEditText);
        signUpButton = findViewById(R.id.signUpNowButton);

        gotToSignInLink.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signUpButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPresenter.registerUser(
                        email.getText().toString(),
                        fullName.getText().toString(),
                        username.getText().toString(),
                        phone.getText().toString(),
                        password.getText().toString(),
                        confirmPassword.getText().toString());
            }
        });
    }

    @Override
    public void showPasswordToast() {
        Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateSuccess() {
        Toast.makeText(this, "Registration Successful, please log in", Toast.LENGTH_SHORT).show();
        Thread waitThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        waitThread.start();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Something went wrong. Please check your connection.", Toast.LENGTH_LONG).show();
    }
}
