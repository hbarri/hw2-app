package com.test.hw2;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

/**
 * Haneen Barri
 * Software Engineering - Professor Derek Doran
 * HW2; implements clock views
 */
public class MainActivity extends AppCompatActivity {

    private static ViewManager vm;
    private static ViewPager vp;
    private static Controller c;

    /**
     * onCreate method to launch main activity and set up tabs
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //launch mainActivity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up viewManager with fragments
        vm = new ViewManager(getSupportFragmentManager());

        //set up viewPager with container
        vp = findViewById(R.id.container);
        //add fragments
        tabsSetUp();

        //set up tab layout with viewPager
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(vp);

        //create model and controller
        Model m = new Model();
        c = new Controller(m);
        //run constructors on ViewObjects
        runViewConstructors();
    }


    /**
     * method to run constructors on views
     */
    private static void runViewConstructors() {
        //run constructor on menu class
        ((Menu)vm.getItem(0)).constructor(c);
        //run constructors on views
        for(int i = 1; i < vm.getCount(); i++) {
            ((ViewObj)vm.getItem(i)).constructor(c);
        }
    }

    /**
     * method to set up tabs on create
     */
    private void tabsSetUp() {
        //create menu and view tabs
        vm.addFragment(new Menu(), "Menu");
        vm.addFragment(new view1(), "Digital View");
        vm.addFragment(new view2(), "Analog View");
        vp.setAdapter(vm);
    }


    /**
     * method to add another digital view
     */
    public static void addView1() {
        //adds another digital view
        vm.addFragment(new view1(), "Digital View");
        vp.setAdapter(vm);
        //runs constructor again
        runViewConstructors();
    }

    /**
     * method to add another analog view
     */
    public static void addView2() {
        //adds another analog view
        vm.addFragment(new view2(), "Analog View");
        vp.setAdapter(vm);
        //runs constructor again
        runViewConstructors();
    }
}
