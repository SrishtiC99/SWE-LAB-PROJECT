package com.cse.swelabproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cse.swelabproject.BookDetailActivity;
import com.cse.swelabproject.Entity.Book;
import com.cse.swelabproject.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    private List<Book> allBooks;
    private Context context;
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
        holder.bookRating.setText("Rating: " + String.valueOf(book.getRating()));
        holder.bookPrice.setText("Rs. " + String.valueOf(book.getPrice()));
        holder.sellerName.setText("By " + book.getSellerName());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookDetailActivity.class);
                intent.putExtra("BOOK", book);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(allBooks == null)
         return 0;
        return allBooks.size();
    }

    class BookHolder extends RecyclerView.ViewHolder{
        private LinearLayout parentLayout;
        private ImageView bookImage;
        private TextView bookTitle;
        private TextView bookRating;
        private TextView bookPrice;
        private TextView sellerName;

        public BookHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            bookImage = itemView.findViewById(R.id.book_iv);
            bookTitle = itemView.findViewById(R.id.title_tv);
            bookRating = itemView.findViewById(R.id.rating_tv);
            bookPrice = itemView.findViewById(R.id.price_tv);
            sellerName = itemView.findViewById(R.id.seller_name_tv);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

    }
}
