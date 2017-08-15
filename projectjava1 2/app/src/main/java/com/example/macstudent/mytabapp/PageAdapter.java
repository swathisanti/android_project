package com.example.macstudent.mytabapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.cart;
import layout.home;
import layout.profile;

/**
 * Created by macstudent on 2017-04-22.
 */

public class PageAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs;

    public PageAdapter (FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                home tab1 = new  home ();
                return  tab1;
            case 1:
                profile tab2 = new profile();
                return tab2;
            case 2:
                cart tab3 = new cart();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}