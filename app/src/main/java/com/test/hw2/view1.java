package com.test.hw2;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * View for digital view
 * extends Fragment to create in tab
 * implements ViewObj
 */
public class view1 extends Fragment implements ViewObj {

    private Controller c;
    private View rootView;

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
        if(rootView == null) rootView = inflater.inflate(R.layout.view1, container, false);

        //launch handler to update clock every second
        final Handler refreshHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //receives clock
                getClock();
                //sets delay of 1 second
                refreshHandler.postDelayed(this, 1 * 1000);
            }
        };
        //sets delay of one mili
        refreshHandler.postDelayed(runnable, 1);

        return rootView;
    }

    /**
     * getClock to get time and date
     */
    @Override
    public void getClock() {
        //gets textview
        TextView tv = (TextView) rootView.findViewById(R.id.clock1);

        int hr = 0;
        //edit hour to 12-hr instead of 24-hr
        if (c.getHour() > 12) hr = c.getHour()-12;
        else hr = c.getHour();
        //set textview to time and date of model
        try {
            String str = hr + ":" + c.getMin() + ":" + c.getSec()
                    + "\n" + c.getMonth() + "/" + c.getDay() + "/" + c.getYear();
            tv.setText(str);
        } catch (Exception e) {
            //catch exception otherwise
            tv.setText(e.toString());
        }
    }
}
