package com.cse.swelabproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cse.swelabproject.Entity.User;
import com.cse.swelabproject.R;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(UtilsClass.currentUser == null){
            // Launch Login Page
            // TODO Open Login activity from here and after login use the details and create a user.
            //  Set this user to this static currentUser variable.
            UtilsClass.currentUser = new User("Srishti Kumari", "xyz@gmail.com", "112233");
        }
        setContentView(R.layout.activity_profile);
        setTitle(UtilsClass.currentUser.getName());
        Button bookUploadButton = findViewById(R.id.upload_book_button);
        bookUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, BookUploadPageActivity.class);
                startActivity(intent);
            }
        });
    }
}