package com.test.hw2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * View for analog view
 * extends Fragment to create in tab
 * implements ViewObj
 */
public class view2 extends Fragment implements ViewObj {

    private View rootView;
    private Controller c;

    /**
     * constructor to receive controller
     */
    @Override
    public void constructor(Controller _c) {
        c = _c;
        //register view with controller
        c.registerView(this);
    }

    /**
     * OnCreateView to launch view
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //reassign view only if null to avoid resetting view
        if(rootView == null) rootView = inflater.inflate(R.layout.view2, container, false);

        //find analog view
        final CustomAnalogClock customAnalogClock = rootView.findViewById(R.id.clock);
        //set scale
        customAnalogClock.setScale(2f);

        //launch handler to update clock every second
        final Handler refreshHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //get date
                getClock();
                //set time for analog clock
                customAnalogClock.setTime(c.getHour(), c.getMin(), c.getSec());
                //refresh every 1 second
                refreshHandler.postDelayed(this, 1 * 1000);
            }
        };
        //set delay every mili
        refreshHandler.postDelayed(runnable, 1);

        return rootView;
    }

    /**
     * getClock to get date
     */
    @Override
    public void getClock() {
        //gets textview
        TextView tv = (TextView) rootView.findViewById(R.id.clock2);

        try {
            //set textview to date of model
            String str = c.getMonth() + "/" + c.getDay() + "/" + c.getYear();
            tv.setText(str);
        } catch (Exception e) {
            //catch exception otherwise
            tv.setText(e.toString());
        }
    }
}
