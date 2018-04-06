package com.example.guest.stormtrooper.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.adapters.FirebaseNotesListAdapter;
import com.example.guest.stormtrooper.adapters.FirebaseNotesViewHolder;
import com.example.guest.stormtrooper.models.Note;
import com.example.guest.stormtrooper.util.OnStartDragListener;
import com.example.guest.stormtrooper.util.SimpleTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedNotesListActivity extends AppCompatActivity  {
//    private DatabaseReference mNoteReference;
//    private FirebaseNotesListAdapter mFirebaseAdapter;
//    private ValueEventListener mNoteFireBaseListener;
//    private ItemTouchHelper mItemTouchHelper;
//
//    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_notes_list); //may need to change this
        ButterKnife.bind(this);


//        setUpFirebaseAdapter();

    }

//    private void setUpFirebaseAdapter() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        mNoteReference = FirebaseDatabase
//                .getInstance()
//                .getReference(Constants.FIREBASE_CHILD_NOTES)
//                .child(uid);
//
//
//        mFirebaseAdapter = new FirebaseNotesListAdapter(Note.class, R.layout.note_list_item_drag, FirebaseNotesViewHolder.class,
//                        mNoteReference, this, this);
//
//
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//
//        ItemTouchHelper.Callback callback = new SimpleTouchHelperCallback(mFirebaseAdapter);
//
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mFirebaseAdapter.cleanup();
//    }
//
//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
//        mItemTouchHelper.startDrag(viewHolder);
//    }
}
