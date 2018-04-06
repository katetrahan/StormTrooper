package com.example.guest.stormtrooper.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.stormtrooper.Constants;
import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.adapters.FirebaseNotesListAdapter;
import com.example.guest.stormtrooper.adapters.FirebaseNotesViewHolder;
import com.example.guest.stormtrooper.models.Note;
import com.example.guest.stormtrooper.util.OnStartDragListener;
import com.example.guest.stormtrooper.util.SimpleTouchHelperCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SavedNotesListFragment extends Fragment implements OnStartDragListener {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private FirebaseNotesListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;


    public SavedNotesListFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_saved_notes_list, container, false);

        ButterKnife.bind(this,view);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_NOTES)
                .child(uid);
//                .orderByChild(Constants.FIREBASE_QUERY_INDEX);

        mFirebaseAdapter = new FirebaseNotesListAdapter(Note.class,R.layout.note_list_item_drag, FirebaseNotesViewHolder.class, query, this, getActivity());

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleTouchHelperCallback(mFirebaseAdapter);

        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder){
        mItemTouchHelper.startDrag(viewHolder);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}
