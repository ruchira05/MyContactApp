package com.example.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ContactDetailsActivity extends AppCompatActivity {
    private int position;
    private TextView profileLetter, viewName, viewPhone, viewAddress, viewDob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(null);
        }

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Retrieve position from Intent extras
        position = getIntent().getIntExtra("position", -1);

        // Check if position is valid
        if (position != -1 && position < ContactList.contactList.size()) {
            Contact contact = ContactList.contactList.get(position);
            profileLetter = findViewById(R.id.profileLetter);
            viewName = findViewById(R.id.viewName);
            viewPhone = findViewById(R.id.viewPhone);
            viewAddress = findViewById(R.id.viewAddress);
            viewDob = findViewById(R.id.viewDob);

            profileLetter.setText(contact.getName().substring(0, 1));
            viewName.setText("Name: " + contact.getName());
            viewPhone.setText("Phone Number: " + contact.getPhoneNumber());
            viewAddress.setText("Address: " + contact.getAddress());
            viewDob.setText("Date of Birth: " + contact.getDob());
        } else {
            // Handle invalid position
            // For example, show a toast or finish the activity
            Toast.makeText(this, "Invalid contact position", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
