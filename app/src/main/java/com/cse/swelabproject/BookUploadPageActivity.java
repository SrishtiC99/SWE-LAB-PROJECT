package com.cse.swelabproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cse.swelabproject.Entity.Book;
import com.cse.swelabproject.Entity.User;
import com.cse.swelabproject.ViewModel.BookViewModel;

public class BookUploadPageActivity extends AppCompatActivity {
    private ImageView bookIV;
    private EditText titleET;
    private EditText descriptionET;
    private EditText quantityET;
    private EditText priceET;
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_upload_page);

        Button uploadButton = findViewById(R.id.upload_button);

        //bookIV = findViewById(R.id.book_iv);
        titleET = findViewById(R.id.book_title_et);
        descriptionET = findViewById(R.id.book_description_et);
        quantityET = findViewById(R.id.book_quantity_et);
        priceET = findViewById(R.id.book_price_et);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadBook();
            }
        });
    }

    private void uploadBook(){
        String title = titleET.getText().toString();
        String description = descriptionET.getText().toString();
        int quantity = Integer.parseInt(quantityET.getText().toString());
        double price = Double.parseDouble(priceET.getText().toString());

        Book book = new Book(title, description, price);
        book.setQuantity(quantity);
        book.setSellerId(UtilsClass.currentUser.getName() + UtilsClass.currentUser.getEmailId());
        book.setSellerName(UtilsClass.currentUser.getName());

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        bookViewModel.insert(book);
        Toast.makeText(BookUploadPageActivity.this, "WOW You uploaded a new Book!!", Toast.LENGTH_SHORT).show();
        finish();
    }
}