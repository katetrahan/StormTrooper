package com.example.guest.stormtrooper;


import android.content.Context;
import android.widget.ArrayAdapter;

public class RecArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecreation;

    public RecArrayAdapter(Context mContext, int resource, String[] mRecreation){
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecreation = mRecreation;
    }

    @Override
    public Object getItem(int position) {
        String recreation = mRecreation[position];
        return String.format(" \nIdeas: %s", recreation);
    }

    @Override
    public int getCount() {
        return mRecreation.length;
    }
}
