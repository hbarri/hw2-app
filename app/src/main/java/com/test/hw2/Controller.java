package com.test.hw2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller to get and set variables from Model
 */
public class Controller implements Serializable {
    private Model m;
    private List<ViewObj> views;

    /**
     * contructor to set model passed and instantiate arrayList
     * @param _m model
     */
    public Controller(Model _m) {
        m = _m;
        views = new ArrayList<>();
    }

    /**
     * method to register views objects created
     * @param v ViewObj to add to list
     */
    public void registerView(ViewObj v) {
        views.add(v);
    }

    /**
     * method to get seconds from model
     * @return seconds
     */
    public int getSec() {
        return m.getSec();
    }

    /**
     * method to set seconds in model
     * @param sec to set
     */
    public void setSec(int sec) {
        m.setSec(sec);
    }

    /**
     * method to get minutes from model
     * @return minutes
     */
    public int getMin() {
        return m.getMin();
    }

    /**
     * method to set minutes in model
     * @param min to set
     */
    public void setMin(int min) {
        m.setMin(min);
    }

    /**
     * method to get hour from model
     * @return hour
     */
    public int getHour() {
        return m.getHour();
    }

    /**
     * method to set hour in model
     * @param hour to set
     */
    public void setHour(int hour) {
        m.setHour(hour);
    }

    /**
     * method to get day from model
     * @return day
     */
    public int getDay() {
        return m.getDay();
    }

    /**
     * method to set day in model
     * @param day to set
     */
    public void setDay(int day) {
        m.setDay(day);
    }

    /**
     * method to get month from model
     * @return month
     */
    public int getMonth() {
        return m.getMonth();
    }

    /**
     * method to set month in model
     * @param month to set
     */
    public void setMonth(int month) {
        m.setMonth(month);
    }

    /**
     * method to get year from model
     * @return year
     */
    public int getYear() {
        return m.getYear();
    }

    /**
     * method to set year in model
     * @param year to set
     */
    public void setYear(int year) {
        m.setYear(year);
    }
}
