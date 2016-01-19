package net.henorek.plantit.ui.views;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import net.henorek.plantit.R;
import net.henorek.plantit.ui.base.BaseActivity;
import net.henorek.plantit.ui.components.MainScreenAdapter;
import net.henorek.plantit.ui.presenters.MainScreenPresenter;
import net.henorek.plantit.ui.utils.ActivityConfig;
import net.henorek.plantit.ui.utils.ActivityConfigBuilder;

import butterknife.Bind;
import me.relex.circleindicator.CircleIndicator;
import timber.log.Timber;

public class MainScreenActivity extends BaseActivity {

    @Bind(R.id.pager)
    ViewPager viewPager;

    @Bind(R.id.fmsc_special_offer_indicator)
    CircleIndicator _specialOfferIndicator;

    @Override
    protected ActivityConfig getConfig() {
        return new ActivityConfigBuilder(R.layout.activity_main_screen).build();
    }

    @Override
    protected MainScreenPresenter createPresenter() {
        return new MainScreenPresenter();
    }

    @Override
    protected void prepareView(Bundle savedInstanceState) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MainScreenAdapter(fragmentManager));
        _specialOfferIndicator.setViewPager(viewPager);
        Timber.d("No el" + "Coś się zjebało i nie było mnie słychać więc powtórzę jeszcze raz");
    }

    @Override
    protected void addFragments() {

    }

}
