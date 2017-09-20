package com.example.thomas.smartbookmarksfernandes.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.thomas.smartbookmarksfernandes.Models.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 20/09/2017.
 */

public class BooksHelper {

    private static final String TABLE_BOOKS = "Books";
    private static final String COL_ID = "id";
    private static final int NUM_COL_ID = 0;
    private static final String COL_TITLE = "title";
    private static final int NUM_COL_TITLE = 1;
    private static final String COL_AUTHOR = "author";
    private static final int NUM_COL_AUTHOR = 2;
    private static final String COL_GENRE = "genre";
    private static final int NUM_COL_GENRE = 3;

    private SQLiteDatabase db;

    private DataBaseHelper dbHelper;

    public BooksHelper(Context context) {
        //On crée la BDD et sa table
        dbHelper = new DataBaseHelper(context);
    }

    public void open() {
        //on ouvre la BDD en écriture
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        //on ferme l'accès à la BDD
        db.close();
    }

    public SQLiteDatabase getBDD() {
        return db;
    }

    public long insertBook(Book book) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();

        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_TITLE, book.getTitle());
        values.put(COL_AUTHOR, book.getAuthor());
        values.put(COL_GENRE, book.getGenre());

        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_BOOKS, null, values);
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        Cursor cursor = db.rawQuery("select * from " + TABLE_BOOKS, null);

        int nbItems = cursor.getCount();

        while (cursor.moveToNext()) {
            Book book = cursorToBook(cursor);
            books.add(book);
        }

        cursor.close();

        return books;
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Book cursorToBook(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //On créé un livre
        Book book = new Book();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        book.setId(c.getInt(NUM_COL_ID));
        book.setTitle(c.getString(NUM_COL_TITLE));
        book.setAuthor(c.getString(NUM_COL_AUTHOR));
        book.setGenre(c.getString(NUM_COL_GENRE));

        //On retourne le livre
        return book;
    }
}
