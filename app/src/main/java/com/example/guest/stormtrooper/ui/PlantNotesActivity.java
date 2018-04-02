package com.example.guest.stormtrooper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantNotesActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mNotesReference;

    @BindView(R.id.saveNoteButton) Button mSaveNoteButton;
    @BindView(R.id.editNoteText) EditText mEditNoteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mNotesReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_NOTES);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_notes);
        ButterKnife.bind(this);

        mSaveNoteButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSaveNoteButton) {
            String note = mEditNoteText.getText().toString();

            saveNoteToFirebase(note);


        }

    }

    public void saveNoteToFirebase(String note) {
        mNotesReference.setValue(note);
    }

}
