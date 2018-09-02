package com.fehr.nanodegree.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private Context context;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:

                return new CairoFragment().newInstance();
            case 1:

                return new AlexandriaFragment().newInstance();
            case 2:
                return new HurghadaFragment().newInstance();
            case 3:
                return new SharmElShiekhFragment().newInstance();
        }
        return null;

    }


    @Override
    public int getCount() {
        return PAGE_COUNT; //No of Tabs
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return context.getString(R.string.tab_cairo);
            case 1:
                return context.getString(R.string.tab_alexandria);
            case 2:
                return context.getString(R.string.tab_hurghada);
            case 3:
                return context.getString(R.string.tab_sharm);
            default:
                return null;
        }
    }

}
