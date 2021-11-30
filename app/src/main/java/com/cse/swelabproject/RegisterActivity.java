package com.cse.swelabproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cse.swelabproject.Entity.User;
import com.cse.swelabproject.ViewModel.UserViewModel;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText emailET;
    private EditText passwordET;
    private EditText confirmPasswordET;
    private UserViewModel userViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameET = findViewById(R.id.name_et);
        emailET  = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);
        confirmPasswordET = findViewById(R.id.confirm_password_et);

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
        findViewById(R.id.go_to_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    private void registerUser(){
        String name = nameET.getText().toString().trim();
        String email = emailET.getText().toString().trim();
        String password = passwordET.getText().toString().trim();
        String confirmPassword = confirmPasswordET.getText().toString().trim();

        if(name.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){
            Toast.makeText(RegisterActivity.this, "Please enter all the details", Toast.LENGTH_LONG).show();
            return;
        }

        if(!password.equals(confirmPassword)){
            Toast.makeText(RegisterActivity.this, "Please enter correct Password", Toast.LENGTH_LONG).show();
            return;
        }

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                for(User u : users){
                    if(u.getEmailId().equals(email) &&  u.getPassword().equals(password)){
                        Toast.makeText(RegisterActivity.this, "You have already registered, Please LogIn to continue", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            }
        });

        User newUser = new User(name, email, password);
        userViewModel.insert(newUser);
        UtilsClass.currentUser = newUser;
        Intent intent = new Intent(RegisterActivity.this, HomePageActivity.class);
        startActivity(intent);
        Toast.makeText(RegisterActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
        finish();
    }
}