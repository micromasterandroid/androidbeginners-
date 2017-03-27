package micromaster.galileo.edu.databaseexample.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import micromaster.galileo.edu.databaseexample.model.Contact;

import static micromaster.galileo.edu.databaseexample.database.DataBaseHelper.COLUMN_EMAIL;
import static micromaster.galileo.edu.databaseexample.database.DataBaseHelper.COLUMN_LAST_NAME;
import static micromaster.galileo.edu.databaseexample.database.DataBaseHelper.COLUMN_NAME;
import static micromaster.galileo.edu.databaseexample.database.DataBaseHelper.COLUMN_PHONE_NUMBER;
import static micromaster.galileo.edu.databaseexample.database.DataBaseHelper.TABLE_CONTACTS;

/**
 * Created by Byron on 3/26/2017.
 */

public class DataBaseDAO {

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase database;

    public DataBaseDAO(Context context) {
        dataBaseHelper = new DataBaseHelper(context);
    }

    public void open() throws SQLException {
        database = dataBaseHelper.getWritableDatabase();
    }

    public void close() {
        dataBaseHelper.close();
    }

    //Insert a new contact on data base
    public void addContact(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contact.getName());
        values.put(COLUMN_LAST_NAME, contact.getLastName());
        values.put(COLUMN_EMAIL, contact.getEmail());
        values.put(COLUMN_PHONE_NUMBER, contact.getPhoneNumber());

        database.insert(TABLE_CONTACTS, null, values);
    }

    //Get all contacts from data base
    public ArrayList<Contact> getAllContacts() {
        ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

        Cursor cursor = database.rawQuery("SELECT  * FROM " + TABLE_CONTACTS, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Contact contact = new Contact();
            contact.setName(cursor.getString(1));
            contact.setLastName(cursor.getString(2));
            contact.setEmail(cursor.getString(3));
            contact.setPhoneNumber(cursor.getString(4));
            contactArrayList.add(contact);

            cursor.moveToNext();
        }

        cursor.close();
        return contactArrayList;
    }

}
