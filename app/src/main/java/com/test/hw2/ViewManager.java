package com.test.hw2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * ViewManager to manage views
 * extends FragmentPagerAdapter to manage tabs
 */
public class ViewManager extends FragmentPagerAdapter {

    //creates lists of fragements and their titles
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();

    /**
     * method to add fragment to lists
     * @param fragment
     * @param title
     */
    public void addFragment(Fragment fragment, String title) {
        //add fragment to list
         fragmentList.add(fragment);
         //add fragment title to list
         fragmentTitleList.add(title);
    }

    /**
     * sets fragment manager
     * @param fm
     */
    public ViewManager(FragmentManager fm) {
        super(fm);
    }

    /**
     * method to get page title
     * @param position
     * @return char sequence
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    /**
     * method to get fragment item at specified index
     * @param i
     * @return
     */
    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    /**
     * method to number of fragments in list
     * @return size
     */
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
