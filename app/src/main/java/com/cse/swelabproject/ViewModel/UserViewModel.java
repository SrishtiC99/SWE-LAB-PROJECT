package com.cse.swelabproject.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cse.swelabproject.Entity.User;
import com.cse.swelabproject.Repository.UserRepo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepo repo;
    private LiveData<List<User>> allUsers;
    public UserViewModel(@NonNull @NotNull Application application) {
        super(application);
        repo = new UserRepo(application);
        allUsers = repo.getAllUsers();
    }

    public void insert(User user){
        repo.insert(user);
    }
    public void update(User user){
        repo.update(user);
    }
    public void delete(User user){
        repo.delete(user);
    }
    public void deleteAll(){
        repo.deleteAll();;
    }
    public LiveData<List<User>> getAllUsers(){
        return allUsers;
    }

}
