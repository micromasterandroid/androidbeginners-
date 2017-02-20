package com.beginner.micromaster.contactlist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.beginner.micromaster.contactlist.R;
import com.beginner.micromaster.contactlist.models.Contact;

import java.util.ArrayList;

/**
 * Created by Byron on 2/19/2017.
 */

public class ContactListAdapter extends ArrayAdapter<Contact> {

    public ContactListAdapter(Context context, ArrayList<Contact> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
        }
        //get reference to object on list
        Contact contact = getItem(position);

        //TODO: Add the rest of references and add the respective values for contact
        TextView contactName = (TextView) convertView.findViewById(R.id.contact_name);
        contactName.setText(contact.getName());

        return convertView;
    }
}