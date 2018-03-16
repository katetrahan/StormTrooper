package com.example.guest.stormtrooper;
import android.content.Context;
import android.widget.ArrayAdapter;

public class RecArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecreation;
    private String[] mWhere;

    public RecArrayAdapter(Context mContext, int resource, String[] mRecreation, String[] mWhere){
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecreation = mRecreation;
        this.mWhere = mWhere;
//        this.mRainyDay = mRainyDay;
    }

    @Override
    public Object getItem(int position) {
        String recreation = mRecreation[position];
//        String rainyDay = mRainyDay[position];
        String where = mWhere[position];
        return String.format("%s \nWhere:%s", recreation, where); //need to add rainyday next week
    }

    @Override
    public int getCount() {
      return mRecreation.length;
//       return mRainyDay.length;
    }
}
