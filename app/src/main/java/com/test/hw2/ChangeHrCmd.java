package com.test.hw2;

import android.view.View;
import android.widget.NumberPicker;

/**
 * Change hour command class
 * implements Command interface
 */
public class ChangeHrCmd implements Command {
    private int prevHr;
    private int newHr;

    /**
     * method to execute command to change the hour
     * @param rootView the view
     * @param c the Controller
     */
    @Override
    public void doIt(View rootView, Controller c) {
        //receives previous hour
        prevHr = c.getHour();
        //gets number picker value
        NumberPicker np = (NumberPicker) rootView.findViewById(R.id.npHr);
        //sets new value
        newHr = np.getValue();
        c.setHour(newHr);
    }

    /**
     * method redo command
     * @param c the Controller
     */
    @Override
    public void redoIt(Controller c) {
        //sets new hour again
        c.setHour(newHr);
    }

    /**
     * method undo command
     * @param c the Controller
     */
    @Override
    public void undoIt(Controller c) {
        //sets to previous hour
        c.setHour(prevHr);
    }
}
