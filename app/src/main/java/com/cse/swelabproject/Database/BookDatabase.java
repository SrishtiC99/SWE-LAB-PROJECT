package com.cse.swelabproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cse.swelabproject.Dao.BookDao;
import com.cse.swelabproject.Entity.Book;

@Database(entities = {Book.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {
    private static BookDatabase instance;
    public abstract BookDao getBookDao();

    public static synchronized BookDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BookDatabase.class,
                    "book_database").build();
        }
        return instance;
    }
}
