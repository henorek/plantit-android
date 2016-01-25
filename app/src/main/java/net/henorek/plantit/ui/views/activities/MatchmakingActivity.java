package net.henorek.plantit.ui.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;

import net.henorek.plantit.R;
import net.henorek.plantit.ui.base.activities.BaseActivity;
import net.henorek.plantit.ui.interfaces.IMatchmakingView;
import net.henorek.plantit.ui.presenters.MatchmakingPresenter;
import net.henorek.plantit.ui.utils.ActivityConfig;
import net.henorek.plantit.ui.utils.ActivityConfigBuilder;
import net.henorek.plantit.ui.utils.FragmentFactory;
import net.henorek.plantit.ui.views.fragments.SelectMapViewFragment;

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
