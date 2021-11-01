package com.cse.swelabproject.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cse.swelabproject.Entity.Book;
import com.cse.swelabproject.Repository.BookRepo;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BookViewModel extends AndroidViewModel {
    private BookRepo repo;
    private LiveData<List<Book>> allBooks;
    public BookViewModel(@NonNull @NotNull Application application) {
        super(application);
        repo = new BookRepo(application);
        allBooks = repo.getAllBooks();
    }

    public void insert(Book book){
        repo.insert(book);
    }
    public void update(Book book){
        repo.update(book);
    }
    public void delete(Book book){
        repo.delete(book);
    }
    public void deleteAll(){
        repo.deleteAll();
    }
    public LiveData<List<Book>> getAllBooks(){
        return allBooks;
    }
}
