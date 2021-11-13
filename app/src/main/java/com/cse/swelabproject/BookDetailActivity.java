package com.cse.swelabproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cse.swelabproject.Entity.Book;

public class BookDetailActivity extends AppCompatActivity {
    private Book book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        if(getIntent().hasExtra("BOOK")){
            book = (Book) getIntent().getSerializableExtra("BOOK");
        }
        else{
            finish();
        }
        TextView bookNameTV = findViewById(R.id.detail_book_name);
        TextView bookDescriptionTV = findViewById(R.id.detail_description);
        TextView bookPriceTV = findViewById(R.id.detail_book_price);

        Button buyNowButton = findViewById(R.id.buy_now_button);

        bookNameTV.setText(book.getBookTitle());
        bookDescriptionTV.setText(book.getDescription());
        bookPriceTV.setText("Rs. " +  String.valueOf(book.getPrice()));

        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookDetailActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}