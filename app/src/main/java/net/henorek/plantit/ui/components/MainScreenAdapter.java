package net.henorek.plantit.ui.components;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.henorek.plantit.ui.views.fragments.FragmentA;
import net.henorek.plantit.ui.views.fragments.FragmentB;
import net.henorek.plantit.ui.views.fragments.FragmentC;

/**
 * Created by Jarek Jankowski.
 * jarosz1994@gmail.com
 */
public class MainScreenAdapter extends FragmentPagerAdapter {

    public MainScreenAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            case 2:
                fragment = new FragmentC();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
