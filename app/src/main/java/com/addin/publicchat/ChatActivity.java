package com.addin.publicchat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.addin.publicchat.adapters.MessagesAdapter;
import com.addin.publicchat.models.Message;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private MessagesAdapter messagesAdapter;
    // Membuat daftar pesan kosong
    private List<Message> messages = new ArrayList<>();

    private EditText etMessage;
    private ImageButton ibSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



        FirebaseDatabase database = FirebaseDatabase.getInstance();

        etMessage = findViewById(R.id.et_message);
        ibSend = findViewById(R.id.ib_send);

        ibSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference newMessageRef = database.getReference("/messages");
                Message newMessage = new Message(etMessage.getText().toString(), "xxxxx", 1231231.00);
                newMessageRef.push().setValue(newMessage);

                etMessage.setText("");
            }
        });

        mAuth = FirebaseAuth.getInstance();
        messagesAdapter = new MessagesAdapter(messages, this);

        RecyclerView rvMessages = (RecyclerView) findViewById(R.id.rv_messages);
        rvMessages.setAdapter(messagesAdapter);
        // Set layout manager to position the items
        rvMessages.setLayoutManager(new LinearLayoutManager(this));


        DatabaseReference messagesRef = database.getReference("/messages");

        messagesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Message newMessage = snapshot.getValue(Message.class);
                messagesAdapter.addItem(newMessage);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        Button btnLogout = findViewById(R.id.btn_logout);

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mAuth.signOut();
//                Intent intent = new Intent(ChatActivity.this, LoginActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(intent);
//            }
//        });
    }
}