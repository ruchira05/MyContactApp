package com.example.mycontact;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView profileLetter, name, phone;
    TextView deleteButton;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        profileLetter = itemView.findViewById(R.id.profileLetter);
        name = itemView.findViewById(R.id.name);
        phone = itemView.findViewById(R.id.phone);
        deleteButton = itemView.findViewById(R.id.deleteButton);
    }
}