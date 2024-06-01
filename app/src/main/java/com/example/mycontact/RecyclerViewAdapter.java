package com.example.mycontact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter <ViewHolder> {
    private ArrayList<Contact> contactArrayListFull;
    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        contactArrayListFull = new ArrayList<>(ContactList.contactList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = ContactList.contactList.get(position);
        holder.profileLetter.setText(contact.getprofileLetter().toString());
        holder.name.setText(contact.getName());
        holder.phone.setText(contact.getPhoneNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, ContactDetailsActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are you sure you want to delete this contact?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                removeContact(holder.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }

    private void removeContact(int position) {
        ContactList.contactList.remove(position);
        notifyItemRemoved(position);
    }
    @Override
    public int getItemCount() {
        return ContactList.contactList.size();
    }

    public Filter getFilter() {
        return contactFilter;
    }

    private Filter contactFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Contact> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(contactArrayListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Contact contact : contactArrayListFull) {
                    if (contact.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(contact);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ContactList.contactList.clear();
            ContactList.contactList.addAll((ArrayList<Contact>) results.values);
            notifyDataSetChanged();
        }
    };
}

