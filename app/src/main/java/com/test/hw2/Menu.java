package com.test.hw2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

/**
 * Menu class to display commands for the user to execute
 */
public class Menu extends Fragment {

    private View rootView;
    private Controller c;

    /**
     * constructor to set Controller passed
     * @param _c Controller
     */
    public void constructor(Controller _c) {
        c = _c;
    }

    /**
     * onCreate method to launch main menu and set up listeners
     * @param savedInstanceState
     * @param inflater
     * @param container
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //set menu xml
        rootView = inflater.inflate(R.layout.menu, container, false);

        //find numberPickers and set min and max values
        NumberPicker npSec = (NumberPicker) rootView.findViewById(R.id.npSec);
        NumberPicker npMin = (NumberPicker) rootView.findViewById(R.id.npMin);
        NumberPicker npHr = (NumberPicker) rootView.findViewById(R.id.npHr);
        NumberPicker npDay = (NumberPicker) rootView.findViewById(R.id.npDay);
        NumberPicker npMonth = (NumberPicker) rootView.findViewById(R.id.npMonth);
        npSec.setMaxValue(59);
        npSec.setMinValue(0);
        npSec.setWrapSelectorWheel(false);
        npMin.setMaxValue(59);
        npMin.setMinValue(0);
        npMin.setWrapSelectorWheel(false);
        npHr.setMaxValue(12);
        npHr.setMinValue(1);
        npHr.setWrapSelectorWheel(false);
        npDay.setMaxValue(31);
        npDay.setMinValue(1);
        npDay.setWrapSelectorWheel(false);
        npMonth.setMaxValue(12);
        npMonth.setMinValue(1);
        npMonth.setWrapSelectorWheel(false);

        //run onClickListener to listen to button click for change second
        rootView.findViewById(R.id.changeSec).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create change second command, add to queue, and execute
                CommandQ.push(new ChangeSecCmd());
                CommandQ.getCommand().doIt(rootView, c);
            }
        });

        //run onClickListener to listen to button click for change minute
        rootView.findViewById(R.id.changeMin).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create change minute command, add to queue, and execute
                CommandQ.push(new ChangeMinCmd());
                CommandQ.getCommand().doIt(rootView, c);
            }
        });

        //run onClickListener to listen to button click for change hour
        rootView.findViewById(R.id.changeHr).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create change hour command, add to queue, and execute
                CommandQ.push(new ChangeHrCmd());
                CommandQ.getCommand().doIt(rootView, c);
            }
        });

        //run onClickListener to listen to button click for change day
        rootView.findViewById(R.id.changeDay).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create change day command, add to queue, and execute
                CommandQ.push(new ChangeDayCmd());
                CommandQ.getCommand().doIt(rootView, c);
            }
        });

        //run onClickListener to listen to button click for change month
        rootView.findViewById(R.id.changeMonth).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create change month command, add to queue, and execute
                CommandQ.push(new ChangeMonthCmd());
                CommandQ.getCommand().doIt(rootView, c);
            }
        });

        //run onClickListener to listen to button click for change year
        rootView.findViewById(R.id.changeYr).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create change year command, add to queue, and execute
                CommandQ.push(new ChangeYrCmd());
                CommandQ.getCommand().doIt(rootView, c);
            }
        });

        //run onClickListener to listen to button click for undo
        rootView.findViewById(R.id.undoBtn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //call undo from CommandQ
                CommandQ.undo(c);
            }
        });

        //run onClickListener to listen to button click for redo
        rootView.findViewById(R.id.redoBtn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //call redo from CommandQ
                CommandQ.redo(c);
            }
        });

        //run onClickListener to listen to button click for opening new digital view
        rootView.findViewById(R.id.openView1Btn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity.addView1();
            }
        });

        //run onClickListener to listen to button click for opening new analog view
        rootView.findViewById(R.id.openView2Btn).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainActivity.addView2();
            }
        });

        return rootView;
    }
}
