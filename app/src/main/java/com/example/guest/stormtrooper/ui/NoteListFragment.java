package com.example.guest.stormtrooper.ui;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.stormtrooper.R;
import com.example.guest.stormtrooper.models.Note;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NoteListFragment extends Fragment {
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private DatabaseReference mNotesReference;
    private ValueEventListener mNoteReferenceListener;
    private Note mNote;


    public NoteListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

}
