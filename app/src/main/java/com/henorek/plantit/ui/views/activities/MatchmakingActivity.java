package com.henorek.plantit.ui.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.henorek.plantit.R;
import com.henorek.plantit.ui.base.activities.BaseActivity;
import com.henorek.plantit.ui.interfaces.IMatchmakingView;
import com.henorek.plantit.ui.presenters.MatchmakingPresenter;
import com.henorek.plantit.ui.utils.ActivityConfig;
import com.henorek.plantit.ui.utils.ActivityConfigBuilder;
import com.henorek.plantit.ui.utils.FragmentFactory;
import com.henorek.plantit.ui.views.fragments.SelectMapViewFragment;

public class MatchmakingActivity extends BaseActivity<IMatchmakingView, MatchmakingPresenter> implements IMatchmakingView {

    @Override
    protected ActivityConfig getConfig() {
        return new ActivityConfigBuilder(R.layout.activity_matchmaking_screen).build();
    }

    @Override
    protected void prepareView(Bundle savedInstanceState) {

    }

    @Override
    protected void addFragments() {
        getSupportFragmentManager().beginTransaction().add(R.id.choose_map_fragment, FragmentFactory.createFragmentByClass(SelectMapViewFragment.class, new Bundle())).commitAllowingStateLoss();
    }

    @NonNull
    @Override
    public MatchmakingPresenter createPresenter() {
        return new MatchmakingPresenter();
    }
}
