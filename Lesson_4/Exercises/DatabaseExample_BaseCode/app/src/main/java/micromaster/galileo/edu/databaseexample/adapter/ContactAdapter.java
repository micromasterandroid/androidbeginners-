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
        TextView pokemonName;

        ViewHolder(View view) {
            super(view);
            pokemonName = (TextView) view.findViewById(R.id.userName);
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

        holder.pokemonName.setText(contact.getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}