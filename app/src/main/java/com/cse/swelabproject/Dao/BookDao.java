package com.cse.swelabproject.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.cse.swelabproject.Entity.Book;

import java.util.List;

@Dao
public interface BookDao {
    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    @Query("Delete FROM book_table")
    void deleteAll();

    @Query("SELECT * FROM book_table ORDER BY rating DESC")
    LiveData<List<Book>> getAllBook();
}
