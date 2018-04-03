package com.example.guest.stormtrooper.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Note;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantNotesActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mNotesReference;
    private ValueEventListener mNoteReferenceListener;

    @BindView(R.id.saveNoteButton) Button mSaveNoteButton;
    @BindView(R.id.editNoteText) EditText mEditNoteText;
    @BindView(R.id.alreadySavedButton) Button mAlreadySavedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mNotesReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_NOTES);

        mNoteReferenceListener = mNotesReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot noteSnapshot : dataSnapshot.getChildren()) {
                    String note = noteSnapshot.getValue().toString();
                    Log.d("note updated", "note updated " + note);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_notes);
        ButterKnife.bind(this);

        mSaveNoteButton.setOnClickListener(this);
        mAlreadySavedButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveNoteButton) {

//            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//            String uid = user.getUid();
//
//            DatabaseReference restaurantRef = FirebaseDatabase
//                    .getInstance()
//                    .getReference(Constants.FIREBASE_CHILD_NOTES)
//                    .child(uid);
//


            String inputNote = mEditNoteText.getText().toString();

            Note note = new Note(inputNote);

            saveNoteToFirebase(note);


        }

        if(v == mAlreadySavedButton ) {
            Intent intent = new Intent(PlantNotesActivity.this, SavedNotesListActivity.class);
            startActivity(intent);
        }

    }

    public void saveNoteToFirebase(Note note) {
        mNotesReference.push().setValue(note);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNotesReference.removeEventListener(mNoteReferenceListener);
    }


}
