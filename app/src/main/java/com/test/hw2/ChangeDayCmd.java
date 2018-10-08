package com.test.hw2;

import android.view.View;
import android.widget.NumberPicker;

/**
 * Change day command class
 * implements Command interface
 */
public class ChangeDayCmd implements Command {
    private int prevDay;
    private int newDay;

    /**
     * method to execute command to change the day
     * @param rootView the view
     * @param c the Controller
     */
    @Override
    public void doIt(View rootView, Controller c) {
        //get prev day
        prevDay = c.getDay();
        //get value from number picker
        NumberPicker np = (NumberPicker) rootView.findViewById(R.id.npDay);
        //set new value to newDay
        newDay = np.getValue();
        //set day to newDay
        c.setDay(newDay);
    }

    /**
     * method redo command
     * @param c the Controller
     */
    @Override
    public void redoIt(Controller c) {
        //set day back to newday
        c.setDay(newDay);
    }

    /**
     * method undo command
     * @param c the Controller
     */
    @Override
    public void undoIt(Controller c) {
        //set day back to previous day
        c.setDay(prevDay);
    }
}
