package com.example.guest.stormtrooper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedNotesListActivity extends AppCompatActivity {
    private DatabaseReference mNoteReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_notes_list);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mNoteReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_NOTES)
                .child(uid);

//        setUpFirebaseAdapter();
    }

//    private void setUpFirebaseAdapter() {
//        mFirebaseAdapter = new FirebaseRecyclerAdapter<Restaurant, FirebaseRestaurantViewHolder>
//                (Restaurant.class, R.layout.restaurant_list_item, FirebaseRestaurantViewHolder.class,
//                        mRestaurantReference) {
//
       }
