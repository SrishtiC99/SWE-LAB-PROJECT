package com.cse.swelabproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.cse.swelabproject.Dao.UserDao;
import com.cse.swelabproject.Entity.User;

@Database(entities = {User.class}, version = 2)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase instance;
    public abstract UserDao getUserDao();

    public static synchronized UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UserDatabase.class,
                    "user_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
