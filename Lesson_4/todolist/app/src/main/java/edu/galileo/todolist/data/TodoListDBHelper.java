package edu.galileo.todolist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.galileo.todolist.data.TodoListContract.TodoEntry;

public class TodoListDBHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "todolist.db";

    public TodoListDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a table to hold to-do.  A to-do is a task that need to be completed.

        final String SQL_CREATE_TODO_TABLE = "CREATE TABLE " + TodoEntry.TABLE_NAME + " (" +
											 TodoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
											 TodoEntry.COLUMN_DATETEXT + " INTEGER, " +
											 TodoEntry.COLUMN_DESC + " TEXT NOT NULL, " +
											 TodoEntry.COLUMN_DUE_DATE_TEXT + " INTEGER, " +
											 TodoEntry.COLUMN_DONE + " INTEGER, " +
											 "UNIQUE (" + TodoEntry.COLUMN_DESC + ", " + TodoEntry.COLUMN_DATETEXT + ") ON " +
											 "CONFLICT IGNORE" +
											 " );";

        sqLiteDatabase.execSQL(SQL_CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TodoEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
