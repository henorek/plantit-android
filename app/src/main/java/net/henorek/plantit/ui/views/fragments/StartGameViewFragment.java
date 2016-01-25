package net.henorek.plantit.ui.views.fragments;

import android.os.Bundle;

import net.henorek.plantit.R;
import net.henorek.plantit.commons.Navigator;
import net.henorek.plantit.ui.base.fragments.BaseFragment;
import net.henorek.plantit.ui.interfaces.IStartGameView;
import net.henorek.plantit.ui.presenters.StartGamePresenter;

import butterknife.OnClick;

public class StartGameViewFragment extends BaseFragment<IStartGameView, StartGamePresenter> implements IStartGameView {

    @Override
    protected int getResourceId() {
        return R.layout.fragment_start_game_view;
    }

    @Override
    protected void prepareView(Bundle savedInstanceState) {
    }

    @Override
    public StartGamePresenter createPresenter() {
        return new StartGamePresenter();
    }

    @OnClick(R.id.menuStart)
    public void goToStart() {
        Navigator.navigateToMatchmakingActivity(getContext());
    }
}
