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
//        this.mRainyDay = mRainyDay;
    }

    @Override
    public Object getItem(int position) {
        String recreation = mRecreation[position];
//        String rainyDay = mRainyDay[position];
        return String.format(" \n %s", recreation); //need to add rainyday next week
    }

    @Override
    public int getCount() {
      return mRecreation.length;
//       return mRainyDay.length;
    }
}
