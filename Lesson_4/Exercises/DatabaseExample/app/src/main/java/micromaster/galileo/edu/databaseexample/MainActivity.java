package micromaster.galileo.edu.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import micromaster.galileo.edu.databaseexample.adapter.ContactAdapter;
import micromaster.galileo.edu.databaseexample.database.DataBaseDAO;
import micromaster.galileo.edu.databaseexample.model.Contact;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdapter contactAdapter;
    private ArrayList<Contact> contactArrayList;
    DataBaseDAO dataBaseDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Open a connection to database
        dataBaseDAO = new DataBaseDAO(this);
        dataBaseDAO.open();

        contactArrayList = getContactsFromDB();

        recyclerView = (RecyclerView) findViewById(R.id.contact_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        contactAdapter = new ContactAdapter(contactArrayList);
        recyclerView.setAdapter(contactAdapter);

        final Button button = (Button) findViewById(R.id.add_new_contact);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent downloadIntent = new Intent(getApplicationContext(), AddNewContactActivity.class);
                startActivity(downloadIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        contactArrayList.clear();
        contactArrayList.addAll(getContactsFromDB());
        contactAdapter.notifyDataSetChanged();
    }

    private ArrayList<Contact> getContactsFromDB() {
        ArrayList contactList = dataBaseDAO.getAllContacts();
        return contactList;
    }

}