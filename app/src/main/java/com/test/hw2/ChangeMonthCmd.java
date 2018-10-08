package com.test.hw2;

import android.view.View;
import android.widget.NumberPicker;

/**
 * Change month command class
 * implements Command interface
 */
public class ChangeMonthCmd implements Command {
    private int prevMonth;
    private int newMonth;

    /**
     * method to execute command to change the month
     * @param rootView the view
     * @param c the Controller
     */
    @Override
    public void doIt(View rootView, Controller c) {
        //gets month
        prevMonth = c.getMonth();
        //gets value from number picker
        NumberPicker np = (NumberPicker) rootView.findViewById(R.id.npMonth);
        //sets new value
        newMonth = np.getValue();
        c.setMonth(newMonth);
    }

    /**
     * method redo command
     * @param c the Controller
     */
    @Override
    public void redoIt(Controller c) {
        //sets new value once again
        c.setMonth(newMonth);
    }

    /**
     * method undo command
     * @param c the Controller
     */
    @Override
    public void undoIt(Controller c) {
        //sets previous value
        c.setMonth(prevMonth);
    }
}
