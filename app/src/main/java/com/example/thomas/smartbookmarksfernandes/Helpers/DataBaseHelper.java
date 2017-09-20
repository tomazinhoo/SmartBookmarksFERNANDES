package com.example.thomas.smartbookmarksfernandes.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Thomas on 20/09/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "SmartBooks.db";

    private static final String SQL_CREATE_TABLE_BOOKS =
            "CREATE TABLE IF NOT EXISTS Books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "title TEXT NOT NULL," +
                    "author TEXT NOT NULL," +
                    "genre TEXT NOT NULL);";

    private static final String SQL_CREATE_TABLE_COMMENTS =
            "CREATE TABLE IF NOT EXISTS Comments (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "bookId INTEGER NOT NULL," +
                    "pageNumber INTEGER NOT NULL," +
                    "comment TEXT NOT NULL," +
                    "date DATE NOT NULL);";

    DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(SQL_CREATE_TABLE_BOOKS);
            db.execSQL(SQL_CREATE_TABLE_COMMENTS);

            db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(1,'Les fleurs du mal','Charles Baudelaire','Poèmes');");
            db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(2,'Germinal','Emile Zola','Roman');");
            db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(3,'Les misérables','Victor Hugo','Roman');");
            db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(4,'1984','George Orwell','Science-Fiction');");
            db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(5,'Le Meilleur des mondes','Aldous Huxley','Science-Fiction');");
            db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(6,'Vingt mille lieues sous les mers','Jules Verne','Aventure');");
            db.execSQL("INSERT INTO Books (id, title, author, genre) VALUES(7,'Les Trois Mousquetaires','Alexandre Dumas','Aventure');");
        }
        catch (Exception e) {
            Log.w("Table creations", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Books;");
        db.execSQL("DROP TABLE Comments;");
        onCreate(db);
    }
}
