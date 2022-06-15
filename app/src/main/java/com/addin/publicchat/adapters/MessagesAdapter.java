package com.addin.publicchat.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.addin.publicchat.R;
import com.addin.publicchat.models.Message;
import com.addin.publicchat.models.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.ViewHolder> {
    private List<Message> mMessages;
    private Context mContext;


    public MessagesAdapter(List<Message> mMessages, Context mContext) {
        this.mMessages = mMessages;
        this.mContext = mContext;
    }

    public void addItem (Message newMessage) {
        this.mMessages.add(newMessage);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        // Inflate the custom layout
        View messageView = inflater.inflate(R.layout.item_message, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(messageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        Message message = mMessages.get(position);

        // Set item views based on your views and data model
       holder.tvMessage.setText(message.getMessage());

       holder.tvName.setText(message.getFullName());


        Timestamp timestamp = new Timestamp(message.getCreatedAt());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
       holder.tvCreated.setText(dateFormatter.format(timestamp));
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    // Inner class for view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvMessage;
        TextView tvCreated;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvMessage = (TextView) itemView.findViewById(R.id.tv_message);
            tvCreated = (TextView) itemView.findViewById(R.id.tv_created);

        }
    }
}
