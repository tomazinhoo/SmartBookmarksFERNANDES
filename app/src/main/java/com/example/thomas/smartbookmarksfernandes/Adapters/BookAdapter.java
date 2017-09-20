package com.example.thomas.smartbookmarksfernandes.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.thomas.smartbookmarksfernandes.Models.Book;
import com.example.thomas.smartbookmarksfernandes.R;

import java.util.List;

/**
 * Created by Thomas on 20/09/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listview_row_book, parent, false);
        }

        BookViewHolder viewHolder = (BookViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new BookViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.textViewTitle);
            viewHolder.author = (TextView) convertView.findViewById(R.id.textViewAuthor);
            viewHolder.genre = (TextView) convertView.findViewById(R.id.textViewGenre);
            viewHolder.nbComments = (TextView) convertView.findViewById(R.id.textViewNbComments);
            convertView.setTag(viewHolder);
        }

        Book book = getItem(position);
        viewHolder.title.setText(book.getTitle());
        viewHolder.author.setText(book.getAuthor());
        viewHolder.genre.setText(book.getGenre());
        viewHolder.nbComments.setText(book.getNbComments());

        return convertView;
    }

    private class BookViewHolder {
        public TextView title;
        public TextView author;
        public TextView genre;
        public TextView nbComments;
    }
}
