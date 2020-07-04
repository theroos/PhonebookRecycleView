package com.example.theroos.phonebookrecycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    Context mContext;
    List<Contacts> contactsList;

    public ContactAdapter(Context mContext, List<Contacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(mContext).inflate(R.layout.item_contacts,parent,false);
        return new ContactViewHolder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacts contact = contactsList.get(position);
        holder.contacts_name.setText(contact.getName());
        holder.contacts_number.setText(contact.getNumber());
        if(contact.getPhoto() != null){
            Picasso.get().load(contact.getPhoto()).into(holder.contact_image);
        } else {
            holder.contact_image.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView contacts_name, contacts_number;
        CircleImageView contact_image;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            contacts_name = itemView.findViewById(R.id.contact_name);
            contacts_number = itemView.findViewById(R.id.contact_number);
            contact_image = itemView.findViewById(R.id.contact_image);
        }
    }
}
