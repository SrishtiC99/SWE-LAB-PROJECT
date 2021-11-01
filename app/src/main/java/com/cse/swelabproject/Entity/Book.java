package com.cse.swelabproject.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private int bookId;

    private String bookTitle;
    private String image;
    private String description;
    private int quantity;
    private double price;
    private double rating;

    public Book(String bookTitle, String description, double price) {
        this.bookTitle = bookTitle;

        this.description = description;

        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
