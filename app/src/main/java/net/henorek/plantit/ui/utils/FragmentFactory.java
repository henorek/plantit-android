package net.henorek.plantit.ui.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Jarek Jankowski on 2016-01-25.
 * jarosz1994@gmail.com
 */
public class FragmentFactory {

    private static Fragment createFragmentByClassName(String className, Bundle bundle) {
        try {
            return createFragmentByClass(Class.forName(className), bundle);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Fragment createFragmentByClass(Class fragmentClass, Bundle bundle) {
        Fragment fragment = null;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragment;
    }
}
