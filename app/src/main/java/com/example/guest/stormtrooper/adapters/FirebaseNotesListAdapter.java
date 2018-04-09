package com.example.guest.stormtrooper.adapters;


import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MotionEvent;
import android.view.View;

import com.example.guest.stormtrooper.models.Note;
import com.example.guest.stormtrooper.util.ItemTouchHelperAdapter;
import com.example.guest.stormtrooper.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

public class FirebaseNotesListAdapter extends FirebaseRecyclerAdapter<Note, FirebaseNotesViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private int mOrientation;


    public FirebaseNotesListAdapter(Class<Note> modelClass, int modelLayout, Class<FirebaseNotesViewHolder> viewHolderClass,
                                    Query ref, OnStartDragListener onStartDragListener,Context context){
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(final FirebaseNotesViewHolder viewHolder, Note model, int position) {
        viewHolder.bindNote(model);


        viewHolder.mSavedNoteTextView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) { //may change back to motionEvent
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN){
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position){

    }

}
