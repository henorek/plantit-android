package com.henorek.plantit.ui.widgets.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.henorek.plantit.ui.views.fragments.LoginViewFragment;
import com.henorek.plantit.ui.views.fragments.SettingsViewFragment;
import com.henorek.plantit.ui.views.fragments.StartGameViewFragment;
import com.henorek.plantit.ui.views.fragments.TrainingViewFragment;

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
        fragment = new StartGameViewFragment();
        break;
      case 2:
        fragment = new TrainingViewFragment();
        break;
      case 3:
        fragment = new SettingsViewFragment();
        break;
    }
    return fragment;
  }

  @Override public int getCount() {
    return 4;
  }
}
