package com.test.hw2;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Model class to hold variables for views
 */
public class Model {
    private int sec;
    private int min;
    private int hour;
    private int day;
    private int month;
    private int year;

    /**
     * constructor get current time and date
     */
    public Model() {
        //get clock instance
        String clock = Calendar.getInstance().toString();
        //separate to tokens
        String[] clockTokens = clock.split(",");
        //run through tokens
        for (String s : clockTokens) {
            //split again to receive values
            String[] st = s.split("=");
            //set values to variables based on string
            if (st[0].equals("YEAR")) {
                year = Integer.parseInt(st[1]);
            } if (st[0].equals("MONTH")) {
                month = Integer.parseInt(st[1])+1;
            } if (st[0].equals("DAY_OF_MONTH")) {
                day = Integer.parseInt(st[1]);
            } if (st[0].equals("HOUR_OF_DAY")) {
                hour = Integer.parseInt(st[1]);
            } if (st[0].equals("MINUTE")) {
                min = Integer.parseInt(st[1]);
            } if (st[0].equals("SECOND")) {
                sec = Integer.parseInt(st[1]);
            }
        }
        //schedule to run task ever second
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    //task to set timer and update every second
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            //check when to increment and update variables
            sec++;
            if (sec >= 60) {
                min++;
                sec = 0;
            } if (min >= 60) {
                hour++;
                min = 0;
            } if (hour >= 24) {
                day++;
                hour = 0;
            }
        }
    };

    /**
     * method to get seconds
     * @return seconds
     */
    public int getSec() {
        return sec;
    }

    /**
     * method to get second
     * @return sec
     */
    public void setSec(int sec) {
        this.sec = sec;
    }

    /**
     * method to get minute
     * @return minute
     */
    public int getMin() {
        return min;
    }

    /**
     * method to get minute
     * @return min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * method to get hour
     * @return hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * method to get hour
     * @return hour
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * method to get day
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * method to get day
     * @return day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * method to get month
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * method to get month
     * @return month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * method to get year
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * method to get year
     * @return year
     */
    public void setYear(int year) {
        this.year = year;
    }
}
