package micromaster.galileo.edu.databaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import micromaster.galileo.edu.databaseexample.database.DataBaseDAO;
import micromaster.galileo.edu.databaseexample.model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseDAO dataBaseDAO = new DataBaseDAO(this);
        dataBaseDAO.open();

        Contact contact1 = new Contact("Joh", "Smith", "+132654878");
        dataBaseDAO.addContact(contact1);

        ArrayList contactArrayList = dataBaseDAO.getAllContacts();

        Log.d("Contacts", contactArrayList.toString());

        dataBaseDAO.close();

    }
}
