package net.henorek.plantit.ui.views.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import net.henorek.plantit.R;
import net.henorek.plantit.ui.base.activities.BaseActivity;
import net.henorek.plantit.ui.interfaces.IMainScreenView;
import net.henorek.plantit.ui.presenters.MainScreenPresenter;
import net.henorek.plantit.ui.utils.ActivityConfig;
import net.henorek.plantit.ui.utils.ActivityConfigBuilder;
import net.henorek.plantit.ui.widgets.adapters.MainScreenAdapter;

import butterknife.Bind;
import me.relex.circleindicator.CircleIndicator;

public class MainScreenActivity extends BaseActivity<IMainScreenView, MainScreenPresenter> implements IMainScreenView {

    @Bind(R.id.ams_main_pager)
    ViewPager viewPager;

    @Bind(R.id.ams_main_pager_indicator)
    CircleIndicator mainScreenViewIndicator;

    @Override
    protected ActivityConfig getConfig() {
        return new ActivityConfigBuilder(R.layout.activity_main_screen).build();
    }

    @Override
    public MainScreenPresenter createPresenter() {
        return new MainScreenPresenter();
    }

    @Override
    protected void prepareView(Bundle savedInstanceState) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MainScreenAdapter(fragmentManager));
        mainScreenViewIndicator.setViewPager(viewPager);
    }

    @Override
    protected void addFragments() {

    }
}
