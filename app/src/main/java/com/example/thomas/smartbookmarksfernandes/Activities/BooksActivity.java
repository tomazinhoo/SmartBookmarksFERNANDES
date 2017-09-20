package com.example.thomas.smartbookmarksfernandes.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.thomas.smartbookmarksfernandes.Adapters.BookAdapter;
import com.example.thomas.smartbookmarksfernandes.Helpers.BooksHelper;
import com.example.thomas.smartbookmarksfernandes.Models.Book;
import com.example.thomas.smartbookmarksfernandes.R;

import java.util.ArrayList;
import java.util.List;

public class BooksActivity extends AppCompatActivity {

    private ListView listViewBooks;
    private List<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);

        BooksHelper dbBooks = new BooksHelper(this);

        dbBooks.open();

        books = new ArrayList<Book>();
        books = dbBooks.getAllBooks();

        dbBooks.close();

        listViewBooks = (ListView) findViewById(R.id.listViewBooks);
        BookAdapter adapter = new BookAdapter(BooksActivity.this, books);
        listViewBooks.setAdapter(adapter);
    }
}
