package com.henorek.plantit.ui.views.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import butterknife.Bind;
import com.henorek.plantit.R;
import com.henorek.plantit.ui.base.activities.BaseActivity;
import com.henorek.plantit.ui.interfaces.IMainScreenView;
import com.henorek.plantit.ui.presenters.MainScreenPresenter;
import com.henorek.plantit.ui.utils.ActivityConfig;
import com.henorek.plantit.ui.utils.ActivityConfigBuilder;
import com.henorek.plantit.ui.widgets.adapters.MainScreenAdapter;
import me.relex.circleindicator.CircleIndicator;

public class MainScreenActivity extends BaseActivity<IMainScreenView, MainScreenPresenter>
    implements IMainScreenView {

  @Bind(R.id.ams_main_pager) ViewPager viewPager;

  @Bind(R.id.ams_main_pager_indicator) CircleIndicator mainScreenViewIndicator;

  @Override protected ActivityConfig getConfig() {
    return new ActivityConfigBuilder(R.layout.activity_main_screen).build();
  }

  @Override public MainScreenPresenter createPresenter() {
    return new MainScreenPresenter();
  }

  @Override protected void prepareView(Bundle savedInstanceState) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    viewPager.setAdapter(new MainScreenAdapter(fragmentManager));
    mainScreenViewIndicator.setViewPager(viewPager);
  }

  @Override protected void addFragments() {

  }
}
