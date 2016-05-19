package com.henorek.plantit.ui.main_screen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.henorek.plantit.ui.main_screen.about_screen.AboutViewFragment;
import com.henorek.plantit.ui.main_screen.login_screen.LoginViewFragment;
import com.henorek.plantit.ui.main_screen.settings_screen.SettingsViewFragment;
import com.henorek.plantit.ui.main_screen.activities_screen.ActivitiesViewFragment;

public class MainScreenAdapter extends FragmentPagerAdapter {

  public MainScreenAdapter(FragmentManager fragmentManager) {
    super(fragmentManager);
  }

  @Override public Fragment getItem(int position) {
    Fragment fragment = null;
    switch (position) {
      case 0:
        fragment = new LoginViewFragment();
        break;
      case 1:
        fragment = new ActivitiesViewFragment();
        break;
      case 2:
        fragment = new SettingsViewFragment();
        break;
      case 3:
        fragment = new AboutViewFragment();
        break;
    }
    return fragment;
  }

  @Override public int getCount() {
    return 4;
  }
}
