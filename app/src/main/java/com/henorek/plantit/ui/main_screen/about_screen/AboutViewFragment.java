package com.henorek.plantit.ui.main_screen.about_screen;

import android.os.Bundle;
import com.henorek.plantit.R;
import com.henorek.plantit.ui.base.fragments.BaseFragment;

public class AboutViewFragment extends BaseFragment<IAboutView, AboutPresenter>
    implements IAboutView {

  @Override protected int getResourceId() {
    return R.layout.fragment_about_view;
  }

  @Override protected void prepareView(Bundle savedInstanceState) {
  }

  @Override public AboutPresenter createPresenter() {
    return new AboutPresenter();
  }
}
