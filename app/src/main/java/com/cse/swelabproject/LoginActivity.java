package com.cse.swelabproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cse.swelabproject.Entity.User;
import com.cse.swelabproject.ViewModel.UserViewModel;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText emailET;
    private EditText passwordET;

    private UserViewModel userViewModel;
    boolean foundUser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.email_login_et);
        passwordET = findViewById(R.id.password_login_et);

        Button loginButton = findViewById(R.id.login_button);
        Button goToRegistration = findViewById(R.id.go_to_register);

        goToRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }
    private void loginUser(){
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();

        if(email.length() == 0 || password.length() == 0){
            Toast.makeText(LoginActivity.this, "Please enter all the details", Toast.LENGTH_LONG).show();
            return;
        }

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for(User u : users){
                    if(u.getEmailId().equals(email) &&  u.getPassword().equals(password)){
                        UtilsClass.currentUser = u;
                        foundUser = true;
                        break;
                    }
                }
            }
        });
        if(!foundUser){
            Toast.makeText(LoginActivity.this, "Invalid email or Password", Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
        }
    }

}