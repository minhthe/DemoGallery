package com.minhthe.dell.demogallery.customAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ttran230 on 8/17/2016.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 :
                return new MyFragment1();
            case 1:
                return new MyFragment2();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
