package micromaster.galileo.edu.databaseexample.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import micromaster.galileo.edu.databaseexample.R;
import micromaster.galileo.edu.databaseexample.model.Contact;


/**
 * Created by Byron on 3/26/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private ArrayList<Contact> arrayList;

    public ContactAdapter(ArrayList<Contact> arrayList) {
        this.arrayList = arrayList;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userName;
        TextView userLastName;
        TextView userEmail;
        TextView userPhoneNumber;

        ViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.userName);
            userLastName = (TextView) view.findViewById(R.id.last_name);
            userEmail = (TextView) view.findViewById(R.id.email);
            userPhoneNumber = (TextView) view.findViewById(R.id.phone_number);
        }
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = arrayList.get(position);

        holder.userName.setText(contact.getName());
        holder.userLastName.setText(contact.getLastName());
        holder.userEmail.setText(contact.getEmail());
        holder.userPhoneNumber.setText(contact.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}