package com.cse.swelabproject.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.cse.swelabproject.Dao.BookDao;
import com.cse.swelabproject.Database.BookDatabase;
import com.cse.swelabproject.Entity.Book;

import java.util.List;

public class BookRepo {
    private BookDao bookDao;
    private LiveData<List<Book>> allBooks;

    public BookRepo(Application application){
        BookDatabase database = BookDatabase.getInstance(application);
        bookDao = database.getBookDao();
        allBooks = bookDao.getAllBook();
    }

    public void insert(Book book){
        new InsertBookAsyncTask(bookDao).execute(book);
    }

    public void update(Book book){
        new UpdateBookAsyncTask(bookDao).execute(book);
    }

    public void delete(Book book){
        new DeleteBookAsyncTask(bookDao).execute(book);
    }

    public void deleteAll(){
        new DeleteAllBooksAsyncTask(bookDao).execute();
    }

    public LiveData<List<Book>> getAllBooks(){
        return allBooks;
    }

    private static class InsertBookAsyncTask extends AsyncTask<Book, Void, Void> {

        private BookDao bookDao;
        private InsertBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.insert(books[0]);
            return null;
        }
    }
    private static class UpdateBookAsyncTask extends AsyncTask<Book, Void, Void> {

        private BookDao bookDao;
        private UpdateBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.update(books[0]);
            return null;
        }
    }
    private static class DeleteBookAsyncTask extends AsyncTask<Book, Void, Void> {

        private BookDao bookDao;
        private DeleteBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.delete(books[0]);
            return null;
        }
    }
    private static class DeleteAllBooksAsyncTask extends AsyncTask<Void, Void, Void> {

        private BookDao bookDao;
        private DeleteAllBooksAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.deleteAll();
            return null;
        }
    }
}
