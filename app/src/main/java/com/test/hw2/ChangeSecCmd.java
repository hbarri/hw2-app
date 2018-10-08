package com.test.hw2;

import android.view.View;
import android.widget.NumberPicker;

/**
 * Change second command class
 * implements Command interface
 */
public class ChangeSecCmd implements Command {
    private int prevSec;
    private int newSec;

    /**
     * method to execute command to change the second
     * @param rootView the view
     * @param c the Controller
     */
    @Override
    public void doIt(View rootView, Controller c) {
        //gets previous second
        prevSec = c.getSec();
        //gets new number picked
        NumberPicker np = (NumberPicker) rootView.findViewById(R.id.npSec);
        //sets new value
        newSec = np.getValue();
        c.setSec(newSec);
    }

    /**
     * method redo command
     * @param c the Controller
     */
    @Override
    public void redoIt(Controller c) {
        //sets new second again
        c.setSec(newSec);
    }

    /**
     * method undo command
     * @param c the Controller
     */
    @Override
    public void undoIt(Controller c) {
        //sets old seconds again
        c.setSec(prevSec);
    }
}
