package com.henorek.plantit.ui.views.fragments;

import android.os.Bundle;
import butterknife.OnClick;
import com.henorek.plantit.R;
import com.henorek.plantit.commons.Navigator;
import com.henorek.plantit.ui.base.fragments.BaseFragment;
import com.henorek.plantit.ui.interfaces.IStartGameView;
import com.henorek.plantit.ui.presenters.StartGamePresenter;

public class StartGameViewFragment extends BaseFragment<IStartGameView, StartGamePresenter>
    implements IStartGameView {

  @Override protected int getResourceId() {
    return R.layout.fragment_start_game_view;
  }

  @Override protected void prepareView(Bundle savedInstanceState) {
  }

  @Override public StartGamePresenter createPresenter() {
    return new StartGamePresenter();
  }

  @OnClick(R.id.menuStart) public void goToStart() {
    Navigator.navigateToMatchmakingActivity(getContext());
  }
}
