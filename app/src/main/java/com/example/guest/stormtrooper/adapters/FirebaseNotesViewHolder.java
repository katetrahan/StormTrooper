package com.example.guest.stormtrooper.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Note;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseNotesViewHolder extends RecyclerView.ViewHolder {

    View mView;
    Context mContext;
    public TextView mSavedNoteTextView;


    public FirebaseNotesViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
//       itemView.setOnClickListener(this);
    }

    public void bindNote (Note note) {

        mSavedNoteTextView = (TextView) mView.findViewById(R.id.savedNoteTextView);
//        TextView savedNoteTextView = (TextView) mView.findViewById(R.id.savedNoteTextView);

        mSavedNoteTextView.setText(note.getNote());

//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_NOTES);
    }




}
