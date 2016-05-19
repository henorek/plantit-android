package com.henorek.plantit.ui.main_screen.activities_screen;

import android.os.Bundle;
import butterknife.OnClick;
import com.henorek.plantit.R;
import com.henorek.plantit.commons.Navigator;
import com.henorek.plantit.ui.base.fragments.BaseFragment;

public class ActivitiesViewFragment extends BaseFragment<IActivitiesView, ActivitiesPresenter>
    implements IActivitiesView {

  @Override protected int getResourceId() {
    return R.layout.fragment_activities_view;
  }

  @Override protected void prepareView(Bundle savedInstanceState) {
  }

  @Override public ActivitiesPresenter createPresenter() {
    return new ActivitiesPresenter();
  }

  @OnClick(R.id.menuStart) public void goToStart() {
    Navigator.navigateToMatchmakingActivity(getContext());
  }
}
