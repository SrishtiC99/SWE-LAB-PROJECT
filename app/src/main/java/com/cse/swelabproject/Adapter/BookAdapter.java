package com.cse.swelabproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cse.swelabproject.Entity.Book;
import com.cse.swelabproject.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder>{
    private List<Book> allBooks;

    public void setAllBooks(List<Book> books){
        this.allBooks = books;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public BookHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);
        return new BookHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BookHolder holder, int position) {
        Book book = allBooks.get(position);
        holder.bookTitle.setText(book.getBookTitle());
        holder.bookRating.setText(String.valueOf(book.getRating()));
        holder.bookPrice.setText(String.valueOf(book.getPrice()));
    }

    @Override
    public int getItemCount() {
        if(allBooks == null)
         return 0;
        return allBooks.size();
    }

    class BookHolder extends RecyclerView.ViewHolder{
        private ImageView bookImage;
        private TextView bookTitle;
        private TextView bookRating;
        private TextView bookPrice;

        public BookHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            bookImage = itemView.findViewById(R.id.book_iv);
            bookTitle = itemView.findViewById(R.id.title_tv);
            bookRating = itemView.findViewById(R.id.rating_tv);
            bookPrice = itemView.findViewById(R.id.price_tv);
        }
    }
}
